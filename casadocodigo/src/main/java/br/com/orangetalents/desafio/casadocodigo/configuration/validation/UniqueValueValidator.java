package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.orangetalents.desafio.casadocodigo.repository.ValidatorRepository;

public class UniqueValueValidator implements ConstraintValidator<UniqueValueConstraint, Object > {

	private String nomeDoCampo;
	private Class<?> classeDeComparacao;	
	private EntityManager em;
		
	public UniqueValueValidator(EntityManager em) {
		this.em = em;
	}

	@Override
	public void initialize(UniqueValueConstraint constraintAnnotation) {
		classeDeComparacao = constraintAnnotation.classeDeComparacao();
		nomeDoCampo = constraintAnnotation.nomeDoCampo();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//String letraInicialDaclasse = classeDeComparacao.toString().substring(0, 1).toLowerCase();// o retorno eh um fqn da classe. ate é possivel mas sem sentido		
		
//		String query = "SELECT 1 FROM "+classeDeComparacao.getName()+" WHERE "+nomeDoCampo+" =:pvalue";  
//		List<?> resultList = em.createQuery(query).setParameter("pvalue", value).getResultList();
		// ver se posso encapsular essa parte!!!		
		
		return ValidatorRepository.build(em).existEquals(nomeDoCampo, classeDeComparacao.getName() , value); // vereficar se isso esta correto ou eh um verdadeiro improvisso!
	}

	
	

}
