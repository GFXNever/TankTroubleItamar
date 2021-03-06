package com.tanktrouble.game.log;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.tanktrouble.game.reference.References;

public class Logger {
	
	private static Logger logger;
	
	//Initialize as a singleton
	private Logger(){
		this.simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		this.calendar = Calendar.getInstance();
		
		String fileName = References.LOG_NAME + "_" + this.simpleDate.format(this.calendar.getTime()) + "_";
		
		int i = 0;
		while(true){			
			File log = new File("/logs/" + fileName + i + ".log");
			if(!log.exists()) break;
			
			i++;
		}
		fileName += i + ".log";
		try {
			this.logFile = new File("/logs/" + fileName);
			this.logFile.createNewFile();
			this.writer = new PrintWriter(this.logFile);
		} catch (IOException e) {
			ErrorReporting.consoleError(e);
		}
	}

	public static void initializeLogger() {
		Logger.logger = new Logger();
	}
	
	public static Logger getLogger(){
		return logger;
	}
	
	private File logFile;
	private PrintWriter writer;
	
//	static{
//		Game la_game = new Game();
//		la_game.add(new Bunny()); // La Amazing
//		System.out.println("I want bunnies !!!!!");
//		Bunny la_bunny = new Bunny();
//		VoiceGame(); // LETS GO BUNNY
//		la_bunny.run();
//		System.out.println("La bunny is trying to escape !!");
//		while ( catchBunny(la_bunny) ) {
//			System.out.println("Catch that bunny !");
//			if(bunny_Itamar.escaped()){
//				kill(bunny_Itamar);
//				break;
//			}
//		}
//		System.out.println("Game over// you killed my bunny");
//	}
	
	private SimpleDateFormat simpleDate;
	private Calendar calendar;
}
