package org.molgenis.data.mapper.meta;

import org.molgenis.data.mapper.mapping.model.AttributeMapping.AlgorithmState;
import org.molgenis.data.meta.SystemEntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static org.molgenis.AttributeType.ENUM;
import static org.molgenis.AttributeType.TEXT;
import static org.molgenis.data.mapper.meta.MapperPackage.PACKAGE_MAPPER;
import static org.molgenis.data.meta.model.EntityType.AttributeRole.ROLE_ID;
import static org.molgenis.data.meta.model.Package.PACKAGE_SEPARATOR;

@Component
public class AttributeMappingMetaData extends SystemEntityType
{
	private static final String SIMPLE_NAME = "AttributeMapping";
	public static final String ATTRIBUTE_MAPPING = PACKAGE_MAPPER + PACKAGE_SEPARATOR + SIMPLE_NAME;

	public static final String IDENTIFIER = "identifier";
	public static final String TARGET_ATTRIBUTE = "targetAttribute";
	public static final String SOURCE_ATTRIBUTES = "sourceAttributes";
	public static final String ALGORITHM = "algorithm";
	public static final String ALGORITHM_STATE = "algorithmState";

	private final MapperPackage mapperPackage;

	@Autowired
	public AttributeMappingMetaData(MapperPackage mapperPackage)
	{
		super(SIMPLE_NAME, PACKAGE_MAPPER);
		this.mapperPackage = requireNonNull(mapperPackage);
	}

	@Override
	public void init()
	{
		setLabel("Attribute mapping");
		setPackage(mapperPackage);

		addAttribute(IDENTIFIER, ROLE_ID);
		addAttribute(TARGET_ATTRIBUTE).setNillable(false);
		addAttribute(SOURCE_ATTRIBUTES).setDataType(TEXT);
		addAttribute(ALGORITHM).setDataType(TEXT);
		List<String> options = asList(AlgorithmState.values()).stream().map(AlgorithmState::toString).collect(toList());
		addAttribute(ALGORITHM_STATE).setDataType(ENUM).setEnumOptions(options);
	}
}
