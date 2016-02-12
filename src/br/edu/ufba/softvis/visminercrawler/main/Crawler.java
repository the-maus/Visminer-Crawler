package br.edu.ufba.softvis.visminercrawler.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufba.softvis.visminer.antipattern.GodClass;
import br.edu.ufba.softvis.visminer.antipattern.IAntiPattern;
import br.edu.ufba.softvis.visminer.constant.LanguageType;
import br.edu.ufba.softvis.visminer.constant.SCMType;
import br.edu.ufba.softvis.visminer.main.VisMiner;
import br.edu.ufba.softvis.visminer.metric.ATFDMetric;
import br.edu.ufba.softvis.visminer.metric.CCMetric;
import br.edu.ufba.softvis.visminer.metric.IMetric;
import br.edu.ufba.softvis.visminer.metric.NOAMetric;
import br.edu.ufba.softvis.visminer.metric.SLOCMetric;
import br.edu.ufba.softvis.visminer.metric.TCCMetric;
import br.edu.ufba.softvis.visminer.metric.WMCMetric;
import br.edu.ufba.softvis.visminer.model.Repository;

public class Crawler {

	public static void main(String[] args) throws IOException {
		// setup visminer
		VisMiner miner = new VisMiner();
		miner.setDBConfig("dbconfig.properties");
		// setup targeted metrics
		List<IMetric> metrics = new ArrayList<IMetric>();
		List<IAntiPattern> antiPatterns  = new ArrayList<IAntiPattern>();
		metrics.add(new SLOCMetric());
		metrics.add(new CCMetric());
		metrics.add(new ATFDMetric());
		metrics.add(new WMCMetric());
		metrics.add(new TCCMetric());
		metrics.add(new NOAMetric());
		antiPatterns.add(new GodClass());
		// setup repository
		Repository repository = new Repository();
		repository.setDescription("junit");
		repository.setName("junit");
		repository.setPath("/home/visminer/desenvolvimento/projects/junit/.git");
//		repository.setDescription("log4j");
//		repository.setName("log4j");
//		repository.setPath("/home/visminer/desenvolvimento/projects/log4j/.git");
		// setup lang
		List<LanguageType> langs = new ArrayList<LanguageType>();
		langs.add(LanguageType.JAVA);		
		// mine it!
		miner.mineRepository(repository, SCMType.GIT, metrics, antiPatterns, langs);
	}

}
