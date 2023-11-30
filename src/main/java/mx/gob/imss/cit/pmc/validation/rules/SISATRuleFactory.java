package mx.gob.imss.cit.pmc.validation.rules;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.annotation.PostConstruct;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.YamlRuleDefinitionReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.pmc.commons.enums.ParametrosEnum;
import mx.gob.imss.cit.pmc.services.ParametrosService;

@Component
public class SISATRuleFactory {

	private final static Logger logger = LoggerFactory.getLogger(SISATRuleFactory.class);

	@Setter
	@Getter
	private Rules rules;

	@Autowired
	private ParametrosService parametrosService;

	@PostConstruct
	public void creaReglas() {
		MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
		try {
			rules = ruleFactory.createRules(new FileReader(parametrosService
					.obtenerParametro(ParametrosEnum.RUTA_VALIDACION_SISAT.getIdentificador()).getDesParametro()));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
