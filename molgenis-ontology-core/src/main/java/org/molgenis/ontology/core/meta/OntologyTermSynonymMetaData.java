package org.molgenis.ontology.core.meta;

import static java.util.Objects.requireNonNull;
import static org.molgenis.MolgenisFieldTypes.TEXT;
import static org.molgenis.data.meta.EntityMetaData.AttributeRole.ROLE_ID;
import static org.molgenis.data.meta.EntityMetaData.AttributeRole.ROLE_LABEL;
import static org.molgenis.ontology.core.model.OntologyPackage.PACKAGE_ONTOLOGY;

import org.molgenis.data.meta.SystemEntityMetaDataImpl;
import org.molgenis.ontology.core.model.OntologyPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OntologyTermSynonymMetaData extends SystemEntityMetaDataImpl
{
	public final static String SIMPLE_NAME = "OntologyTermSynonym";
	public final static String ONTOLOGY_TERM_SYNONYM = PACKAGE_ONTOLOGY + "_" + SIMPLE_NAME;

	public final static String ID = "id";
	public final static String ONTOLOGY_TERM_SYNONYM_ATTR = "ontologyTermSynonym";

	private OntologyPackage ontologyPackage;

	public OntologyTermSynonymMetaData()
	{
		super(SIMPLE_NAME, PACKAGE_ONTOLOGY);
	}

	@Override
	public void init()
	{
		setPackage(ontologyPackage);

		addAttribute(ID, ROLE_ID).setVisible(false);
		addAttribute(ONTOLOGY_TERM_SYNONYM_ATTR, ROLE_LABEL).setDataType(TEXT).setNillable(false);
	}

	@Autowired
	public void setOntologyPackage(OntologyPackage ontologyPackage)
	{
		this.ontologyPackage = requireNonNull(ontologyPackage);
	}
}