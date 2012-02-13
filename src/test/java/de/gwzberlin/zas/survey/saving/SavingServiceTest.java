//package de.gwzberlin.zas.survey.saving;
//
//import static org.junit.Assert.*;
//
//import java.util.Arrays;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import de.gwzberlin.zas.survey.shared.AlternativeXml;
//import de.gwzberlin.zas.survey.shared.AlternativesXml;
//import de.gwzberlin.zas.survey.shared.NameValuePair;
//import de.gwzberlin.zas.survey.shared.Selection;
//import de.gwzberlin.zas.survey.test.ContextAwareTest;
//
//public class SavingServiceTest extends ContextAwareTest {
//
//	@Autowired
//	SavingService savingService;	
//	
//	AlternativesXml alternatives = new AlternativesXml();
//	AlternativeXml alternative1 = new AlternativeXml();
//	AlternativeXml alternative2 = new AlternativeXml();
//	
//	@Before
//	public void setUp() {
//		alternative1.setColor(new NameValuePair("rot", 0));
//		alternative1.setMaterial(new NameValuePair("Leder", 2));
//		alternatives.setAlternatives(Arrays.asList(alternative1));		
//		savingService.saveAlternatives(alternatives);
//	}
//	
//	@Test
//	public void testLogSelection() {
//		Selection selection = new Selection();
//		selection.setColor("rot");
//		savingService.initialSave(selection);
//	}
//
//	@Test
//	public void testSaveSelectedAlternatives() {
//		
//		alternative2.setColor(new NameValuePair("blau", 0));
//		alternative2.setMaterial(new NameValuePair("Stoff", 2));
//		alternatives.setAlternatives(Arrays.asList(alternative1, alternative2));		
//		savingService.saveAlternatives(alternatives);
//		savingService.saveSelectedAlternatives(Arrays.asList(1));		
//	}
//}
