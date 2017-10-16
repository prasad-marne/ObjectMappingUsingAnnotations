package com.example.mapper;

import com.example.annotation.Dto;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		registerClassMap(factory);
	}

	@Override
	protected void configureFactoryBuilder(DefaultMapperFactory.Builder factoryBuilder) {
		factoryBuilder.mapNulls(false).build();
	}

	private void registerClassMap(MapperFactory factory) {
		Set<Class<?>> classes = new org.reflections.Reflections("com.example.Bean")
				.getTypesAnnotatedWith(Dto.class);
		for (Class<?> source : classes) {
			Class<?> destination = source.getAnnotation(Dto.class).destination();
			log.debug("created class map for A{} to B{}", source, destination);
			factory.classMap(source, destination).byDefault().register();
		}
	}
}
