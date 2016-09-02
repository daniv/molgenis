package org.molgenis.data.semanticsearch.repository;

import org.molgenis.data.DataService;
import org.molgenis.data.IdGenerator;
import org.molgenis.data.Query;
import org.molgenis.data.meta.model.AttributeMetaData;
import org.molgenis.data.meta.model.Tag;
import org.molgenis.data.meta.model.TagFactory;
import org.molgenis.data.semantic.Relation;
import org.molgenis.test.data.AbstractMolgenisSpringTest;
import org.molgenis.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.molgenis.data.meta.model.TagMetaData.*;
import static org.testng.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = TagRepositoryTest.Config.class)
public class TagRepositoryTest extends AbstractMolgenisSpringTest
{
	@Autowired
	private TagFactory tagFactory;

	@Autowired
	private DataService dataService;

	private TagRepository tagRepository;

	@Autowired
	private IdGenerator idGenerator;

	private final UUID uuid = UUID.randomUUID();

	@BeforeMethod
	public void beforeMethod()
	{
		tagRepository = new TagRepository(dataService, idGenerator, tagFactory);
		when(idGenerator.generateId()).thenReturn(uuid.toString());
	}

	@Test
	public void testGetTagEntityNew()
	{
		Tag tag = tagFactory.create();
		tag.setIdentifier(uuid.toString());
		tag.setObjectIri("http://edamontology.org/data_3031");
		tag.setLabel("Core data");
		tag.setRelationIri("http://molgenis.org/biobankconnect/instanceOf");
		tag.setRelationLabel("instanceOf");
		tag.setCodeSystem("http://edamontology.org");

		Query<Tag> q = mock(Query.class);
		when(q.eq(anyString(), any())).thenReturn(q);
		when(q.and()).thenReturn(q);
		when(q.findOne()).thenReturn(null);
		when(dataService.query(TAG, Tag.class)).thenReturn(q);

		assertTrue(EntityUtils.equals(tagRepository
				.getTagEntity("http://edamontology.org/data_3031", "Core data", Relation.instanceOf,
						"http://edamontology.org"), tag));

		verify(dataService, times(1)).add(eq(TAG), any(Tag.class));
	}

	@Test
	public void testGetTagEntityExisting()
	{
		Tag tag = tagFactory.create();
		tag.setIdentifier(uuid.toString());
		tag.setObjectIri("http://edamontology.org/data_3031");
		tag.setLabel("Core data");
		tag.setRelationIri("http://molgenis.org/biobankconnect/instanceOf");
		tag.setRelationLabel("instanceOf");
		tag.setCodeSystem("http://edamontology.org");

		Query q = mock(Query.class);
		when(q.eq(OBJECT_IRI, "http://edamontology.org/data_3031")).thenReturn(q);
		when(q.and()).thenReturn(q);
		when(q.eq(RELATION_IRI, "http://molgenis.org/biobankconnect/instanceOf")).thenReturn(q);
		when(q.and()).thenReturn(q);
		when(q.eq(CODE_SYSTEM, "http://edamontology.org")).thenReturn(q);
		when(q.findOne()).thenReturn(tag);
		when(dataService.query(TAG, Tag.class)).thenReturn(q);

		assertTrue(EntityUtils.equals(tagRepository
				.getTagEntity("http://edamontology.org/data_3031", "Core data", Relation.instanceOf,
						"http://edamontology.org"), tag));
	}

	@Configuration
	public static class Config
	{
		@Bean
		DataService dataService()
		{
			return mock(DataService.class);
		}

		@Bean
		IdGenerator idGenerator()
		{
			return mock(IdGenerator.class);
		}

		@Bean
		AttributeMetaData attributeMetaData()
		{
			return mock(AttributeMetaData.class);
		}
	}
}