package mx.gob.imss.cit.pmc.validation.launcher.impl;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.gob.imss.cit.pmc.commons.dto.BitacoraErroresDTO;
import mx.gob.imss.cit.pmc.commons.dto.CifrasControlDTO;
import mx.gob.imss.cit.pmc.commons.dto.RegistroDTO;
import mx.gob.imss.cit.pmc.services.CatalogosService;
import mx.gob.imss.cit.pmc.validation.launcher.LauncherSUI55;
import mx.gob.imss.cit.pmc.validation.rules.SUI55RuleFactory;

@Component
public class LauncherSUI55Impl implements LauncherSUI55 {

	@Autowired
	private SUI55RuleFactory sUI55RuleFactory;
	
	@Autowired
	private CatalogosService catalogosService;

	@Override
	public void validaRegistro(RegistroDTO registroDTO) {		
		Facts facts = new Facts();
		List<BitacoraErroresDTO> errores = new ArrayList<BitacoraErroresDTO>();
		CifrasControlDTO cifrasControlDTO = new CifrasControlDTO();
		facts.put("registroDTO", registroDTO);
		facts.put("errores", errores);
		facts.put("cifrasControlDTO", cifrasControlDTO);
		facts.put("fechaHabilInicio", catalogosService.obtenerFechasInhabiles(-5));
		facts.put("fechaHabilFin", catalogosService.obtenerFechasInhabiles(5));

		RulesEngine rulesEngine = new DefaultRulesEngine();

		rulesEngine.fire(sUI55RuleFactory.getRules(), facts);
		if (errores != null && !errores.isEmpty()) {
			registroDTO.setBitacoraErroresDTO(errores);
			BitacoraErroresDTO bitacoraErroresDTO = errores.get(0);
			registroDTO.setCveCodigoError(bitacoraErroresDTO.getCveIdCodigoError());
		}
		registroDTO.setCifrasControlDTO(cifrasControlDTO);
	}

}
