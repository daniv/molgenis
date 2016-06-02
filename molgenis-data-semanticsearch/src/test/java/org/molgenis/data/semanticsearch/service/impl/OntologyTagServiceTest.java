package org.molgenis.data.semanticsearch.service.impl;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//@WebAppConfiguration
//@ContextConfiguration(classes = OntologyTagServiceTest.Config.class)
public class OntologyTagServiceTest extends AbstractTestNGSpringContextTests
{
	//	private OntologyTagServiceImpl ontologyTagService;
	//
	//	@Autowired
	//	private TagRepository tagRepository;
	//
	//	@Autowired
	//	private OntologyService ontologyService;
	//
	//	@Autowired
	//	private DataService dataService;
	//
	//	private MapEntity chromosomeNameTagEntity;
	//
	//	private MapEntity geneAnnotationTagEntity;
	//
	//	private final Relation instanceOf = Relation.valueOf("instanceOf");
	//
	//	public static final Ontology EDAM_ONTOLOGY = Ontology.create("EDAM", "http://edamontology.org",
	//			"The EDAM ontology.");
	//
	//	public static final OntologyTerm CHROMOSOME_NAME_ONTOLOGY_TERM = OntologyTerm.create(
	//			"http://edamontology.org/data_0987", "Chromosome name", "Name of a chromosome.");
	//
	//	public static final OntologyTerm GENE_ANNOTATION_ONTOLOGY_TERM = OntologyTerm.create(
	//			"http://edamontology.org/data_0919", "Gene annotation (chromosome)",
	//			"This includes basic information. e.g. chromosome number...");
	//
	//	@BeforeTest
	//	public void beforeTest()
	//	{
	//		chromosomeNameTagEntity = new MapEntity();
	//		chromosomeNameTagEntity.set(TagMetaData.IDENTIFIER, "1234");
	//		chromosomeNameTagEntity.set(TagMetaData.LABEL, "Chromosome name");
	//		chromosomeNameTagEntity.set(TagMetaData.OBJECT_IRI, "http://edamontology.org/data_0987");
	//		chromosomeNameTagEntity.set(TagMetaData.RELATION_IRI, instanceOf.getIRI());
	//		chromosomeNameTagEntity.set(TagMetaData.RELATION_LABEL, instanceOf.getLabel());
	//		chromosomeNameTagEntity.set(TagMetaData.CODE_SYSTEM, "http://edamontology.org");
	//
	//		geneAnnotationTagEntity = new MapEntity();
	//		geneAnnotationTagEntity.set(TagMetaData.IDENTIFIER, "4321");
	//		geneAnnotationTagEntity.set(TagMetaData.LABEL, "Gene annotation (chromosome)");
	//		geneAnnotationTagEntity.set(TagMetaData.OBJECT_IRI, "http://edamontology.org/data_0919");
	//		geneAnnotationTagEntity.set(TagMetaData.RELATION_IRI, instanceOf.getIRI());
	//		geneAnnotationTagEntity.set(TagMetaData.RELATION_LABEL, instanceOf.getLabel());
	//		geneAnnotationTagEntity.set(TagMetaData.CODE_SYSTEM, "http://edamontology.org");
	//	}
	//
	//	@BeforeMethod
	//	public void beforeMethod()
	//	{
	//		ontologyTagService = new OntologyTagServiceImpl(dataService, ontologyService, tagRepository, null, null /* FIXME */);
	//	}
	//
	//	@Test
	//	public void testgetTagsForAttribute()
	//	{
	//		EntityMetaData emd = new EntityMetaDataImpl("org.molgenis.SNP");
	//		AttributeMetaData attributeMetaData = new AttributeMetaData("Chr");
	//
	//		Relation instanceOf = Relation.valueOf("instanceOf");
	//
	//		MapEntity attributeEntity = new MapEntity();
	//		attributeEntity.set(AttributeMetaDataMetaData.TAGS,
	//				Arrays.asList(chromosomeNameTagEntity, geneAnnotationTagEntity));
	//		attributeEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//		Entity entityMetaDataEntity = new MapEntity(mock(EntityMetaDataMetaData.class) /*EntityMetaDataMetaData.get() FIXME */);
	//		entityMetaDataEntity.set(EntityMetaDataMetaData.ATTRIBUTES, Collections.singleton(attributeEntity));
	//		when(dataService.findOneById(EntityMetaDataMetaData.TAG, "org.molgenis.SNP")).thenReturn(
	//				entityMetaDataEntity);
	//
	//		Ontology edamOntology = Ontology.create("EDAM", "http://edamontology.org", "The EDAM ontology.");
	//		OntologyTerm chromosomeName = OntologyTerm.create("http://edamontology.org/data_0987", "Chromosome name",
	//				"Name of a chromosome.");
	//		OntologyTerm geneAnnotation = OntologyTerm.create("http://edamontology.org/data_0919",
	//				"Gene annotation (chromosome)", "This includes basic information. e.g. chromosome number...");
	//
	//		when(ontologyService.getOntology("http://edamontology.org")).thenReturn(edamOntology);
	//		when(ontologyService.getOntologyTerm("http://edamontology.org/data_0987")).thenReturn(chromosomeName);
	//		when(ontologyService.getOntologyTerm("http://edamontology.org/data_0919")).thenReturn(geneAnnotation);
	//
	//		Multimap<Relation, OntologyTerm> expected = LinkedHashMultimap.<Relation, OntologyTerm> create();
	//		expected.put(instanceOf, chromosomeName);
	//		expected.put(instanceOf, geneAnnotation);
	//
	//		assertEquals(ontologyTagService.getTagsForAttribute(emd, attributeMetaData), expected);
	//	}
	//
	//	@Test
	//	public void testGetTagEntity()
	//	{
	//		MapEntity expected = new MapEntity(TagMetaData.TAG);
	//		expected.set(TagMetaData.IDENTIFIER, "1233");
	//		expected.set(TagMetaData.OBJECT_IRI, "http://edamontology.org/data_3031");
	//		expected.set(TagMetaData.LABEL, "Core data");
	//		expected.set(TagMetaData.RELATION_IRI, "http://molgenis.org/biobankconnect/instanceOf");
	//		expected.set(TagMetaData.RELATION_LABEL, "instanceOf");
	//		expected.set(TagMetaData.CODE_SYSTEM, "http://edamontology.org");
	//
	//		OntologyTerm coreData = mock(OntologyTerm.class);
	//
	//		when(coreData.getIRI()).thenReturn("http://edamontology.org/data_3031");
	//		when(coreData.getLabel()).thenReturn("Core data");
	//
	//		Ontology edamOntology = mock(Ontology.class);
	//
	//		when(edamOntology.getIRI()).thenReturn("http://edamontology.org");
	//
	//		SemanticTag<Object, OntologyTerm, Ontology> tag = new SemanticTag<Object, OntologyTerm, Ontology>("1233", null,
	//				Relation.instanceOf, coreData, edamOntology);
	//		when(
	//				tagRepository.getTagEntity("http://edamontology.org/data_3031", "Core data", Relation.instanceOf,
	//						"http://edamontology.org")).thenReturn(expected);
	//
	//		assertEquals(ontologyTagService.getTagEntity(tag), expected);
	//
	//	}
	//
	//	@Test
	//	public void testAddAttributeTag()
	//	{
	//		EntityMetaData emd = new EntityMetaDataImpl("org.molgenis.SNP");
	//		AttributeMetaData attributeMetaData = new AttributeMetaData("Chr");
	//
	//		when(ontologyService.getOntology("http://edamontology.org")).thenReturn(EDAM_ONTOLOGY);
	//		when(ontologyService.getOntologyTerm("http://edamontology.org/data_0987")).thenReturn(
	//				CHROMOSOME_NAME_ONTOLOGY_TERM);
	//
	//		MapEntity attributeEntity = new MapEntity();
	//		attributeEntity.set(AttributeMetaDataMetaData.TAGS, Arrays.asList(geneAnnotationTagEntity));
	//		attributeEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//		SemanticTag<AttributeMetaData, OntologyTerm, Ontology> chromosomeTag = new SemanticTag<AttributeMetaData, OntologyTerm, Ontology>(
	//				"1233", attributeMetaData, instanceOf, CHROMOSOME_NAME_ONTOLOGY_TERM, EDAM_ONTOLOGY);
	//
	//		Entity entityMetaDataEntity = new MapEntity(mock(EntityMetaDataMetaData.class)/*.get()*/);
	//		entityMetaDataEntity.set(EntityMetaDataMetaData.ATTRIBUTES, Collections.singleton(attributeEntity));
	//		when(dataService.findOneById(EntityMetaDataMetaData.TAG, "org.molgenis.SNP")).thenReturn(
	//				entityMetaDataEntity);
	//		when(
	//				tagRepository.getTagEntity("http://edamontology.org/data_0987", "Chromosome name", instanceOf,
	//						"http://edamontology.org")).thenReturn(chromosomeNameTagEntity);
	//
	//		ontologyTagService.addAttributeTag(emd, chromosomeTag);
	//
	//		MapEntity updatedEntity = new MapEntity();
	//		updatedEntity.set(AttributeMetaDataMetaData.TAGS,
	//				Arrays.asList(geneAnnotationTagEntity, chromosomeNameTagEntity));
	//		updatedEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//
	//		verify(dataService, times(1)).update(AttributeMetaDataMetaData.TAG, updatedEntity);
	//	}
	//
	//	@Test
	//	public void testRemoveAttributeTag()
	//	{
	//		EntityMetaData emd = new EntityMetaDataImpl("org.molgenis.SNP");
	//		AttributeMetaData attributeMetaData = new AttributeMetaData("Chr");
	//
	//		MapEntity attributeEntity = new MapEntity();
	//		attributeEntity.set(AttributeMetaDataMetaData.TAGS,
	//				Arrays.asList(chromosomeNameTagEntity, geneAnnotationTagEntity));
	//		attributeEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//		Entity entityMetaDataEntity = new MapEntity(mock(EntityMetaDataMetaData.class)/*.get()*/);
	//		entityMetaDataEntity.set(EntityMetaDataMetaData.ATTRIBUTES, Collections.singleton(attributeEntity));
	//		when(dataService.findOneById(EntityMetaDataMetaData.TAG, "org.molgenis.SNP")).thenReturn(
	//				entityMetaDataEntity);
	//
	//		SemanticTag<AttributeMetaData, OntologyTerm, Ontology> geneAnnotationTag = new SemanticTag<AttributeMetaData, OntologyTerm, Ontology>(
	//				"4321", attributeMetaData, instanceOf, GENE_ANNOTATION_ONTOLOGY_TERM, EDAM_ONTOLOGY);
	//
	//		ontologyTagService.removeAttributeTag(emd, geneAnnotationTag);
	//
	//		MapEntity updatedEntity = new MapEntity(attributeEntity);
	//		updatedEntity.set(AttributeMetaDataMetaData.TAGS,
	//				Arrays.asList(chromosomeNameTagEntity, geneAnnotationTagEntity));
	//		verify(dataService).update(AttributeMetaDataMetaData.TAG, updatedEntity);
	//	}
	//
	//	@Test
	//	public void testgetTagsForPackage()
	//	{
	//		Package p = new Package("test", "desc", null);
	//
	//		Entity pack = new MapEntity(mock(PackageMetaData.class)/*.get()*/);
	//		pack.set(PackageMetaData.FULL_NAME, "test");
	//		pack.set(PackageMetaData.SIMPLE_NAME, "test");
	//		pack.set(PackageMetaData.TAGS, asList(chromosomeNameTagEntity));
	//
	//		when(
	//				dataService.findOne(PackageMetaData.TAG,
	//						new QueryImpl<Entity>().eq(PackageMetaData.FULL_NAME, p.getName()))).thenReturn(pack);
	//
	//		assertEquals(ontologyTagService.getTagsForPackage(p),
	//				Arrays.asList(new SemanticTag<Package, OntologyTerm, Ontology>("1234", p, Relation
	//						.forIRI("http://molgenis.org/biobankconnect/instanceOf"), OntologyTerm.create(
	//						"http://edamontology.org/data_0987", "Chromosome name", "Name of a chromosome."), Ontology
	//						.create("EDAM", "http://edamontology.org", "The EDAM ontology."))));
	//	}
	//
	//	@Test
	//	public void testRemoveAllTagsFromEntity()
	//	{
	//		// FIXME This does not make sense...
	//		EntityMetaData emd = new EntityMetaDataImpl("test");
	//		AttributeMetaData amd = new AttributeMetaData("Chr");
	//
	//		emd.addAttribute(amd);
	//		when(dataService.getEntityMetaData("test")).thenReturn(emd);
	//
	//		Entity entityMetaDataEntity = mock(Entity.class);
	//		Entity att = mock(Entity.class);
	//
	//		when(entityMetaDataEntity.getEntities(ATTRIBUTES)).thenReturn(Arrays.asList(att));
	//		when(att.getString(AttributeMetaDataMetaData.NAME)).thenReturn("Chr");
	//
	//		when(dataService.findOneById(TAG, "test")).thenReturn(entityMetaDataEntity);
	//		ontologyTagService.removeAllTagsFromEntity("test");
	//
	//		verify(dataService).update(EntityMetaDataMetaData.TAG, entityMetaDataEntity);
	//	}
	//
	//	@Test
	//	public void testTagAttributesInEntity()
	//	{
	//		Map<String, OntologyTag> attributeTagMap = new HashMap<String, OntologyTag>();
	//		Map<AttributeMetaData, OntologyTerm> tags = new HashMap<AttributeMetaData, OntologyTerm>();
	//
	//		EntityMetaData emd = new EntityMetaDataImpl("org.molgenis.SNP");
	//		AttributeMetaData attributeMetaData = new AttributeMetaData("Chr");
	//
	//		when(ontologyService.getOntology("http://edamontology.org")).thenReturn(EDAM_ONTOLOGY);
	//		when(ontologyService.getOntologyTerm("http://edamontology.org/data_0987")).thenReturn(
	//				CHROMOSOME_NAME_ONTOLOGY_TERM);
	//
	//		MapEntity attributeEntity = new MapEntity();
	//		attributeEntity.set(AttributeMetaDataMetaData.TAGS, Arrays.asList(geneAnnotationTagEntity));
	//		attributeEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//		SemanticTag<AttributeMetaData, OntologyTerm, Ontology> chromosomeTag = new SemanticTag<AttributeMetaData, OntologyTerm, Ontology>(
	//				"1233", attributeMetaData, instanceOf, CHROMOSOME_NAME_ONTOLOGY_TERM, EDAM_ONTOLOGY);
	//
	//		Entity entityMetaDataEntity = new MapEntity(mock(EntityMetaDataMetaData.class)/*.get()*/);
	//		entityMetaDataEntity.set(EntityMetaDataMetaData.ATTRIBUTES, Collections.singleton(attributeEntity));
	//		when(dataService.findOneById(EntityMetaDataMetaData.TAG, "org.molgenis.SNP")).thenReturn(
	//				entityMetaDataEntity);
	//		when(
	//				tagRepository.getTagEntity("http://edamontology.org/data_0987", "Chromosome name", instanceOf,
	//						"http://edamontology.org")).thenReturn(chromosomeNameTagEntity);
	//
	//		ontologyTagService.addAttributeTag(emd, chromosomeTag);
	//
	//		MapEntity updatedEntity = new MapEntity();
	//		updatedEntity.set(AttributeMetaDataMetaData.TAGS,
	//				Arrays.asList(geneAnnotationTagEntity, chromosomeNameTagEntity));
	//		updatedEntity.set(AttributeMetaDataMetaData.NAME, "Chr");
	//
	//		assertEquals(ontologyTagService.tagAttributesInEntity("test", tags), attributeTagMap);
	//	}
	//
	//	@Configuration
	//	public static class Config
	//	{
	//		@Bean
	//		DataService dataService()
	//		{
	//			return mock(DataService.class);
	//		}
	//
	//		@Bean
	//		OntologyService ontologyService()
	//		{
	//			return mock(OntologyService.class);
	//		}
	//
	//		@Bean
	//		TagRepository tagRepository()
	//		{
	//			return mock(TagRepository.class);
	//		}
	//	}
}
