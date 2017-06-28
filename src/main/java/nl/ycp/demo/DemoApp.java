package nl.ycp.demo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoApp {
	
	@Autowired
	private SnackRepository repo;
	
	@Autowired
	private DrankRepository repos;
	
	@Autowired
	private HighScoreRepository hsrepo;
	
	private int oldScore;
	
	
//	HighScore hs = new HighScore();
	
	@RequestMapping(value = "/savescore", method = RequestMethod.GET)
	public String saveScore(Model m){
		
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.now();
		String ldt = dateTime.format(formatter);*/
		//String ldt = "Today";
		
		/*hs.setName("Yaela");
		hs.setDate("Today");
		hs.setScore(461);*/
		//to be inserted into database after game finishes	
		
		return "SaveScore";
		}
	
	@RequestMapping(value = "/savescore", method = RequestMethod.POST)
	public String saveScorePost(HttpServletRequest request){
		HighScore hs = new HighScore();
		String name = request.getParameter("name");
		int score = Integer.parseInt(request.getParameter("score"));
		setOldScore(loadOldHighScore());
		hs.setScore(score);
		hs.setName(name);
		if(score > this.oldScore){
		hs.setOldHighScore(score);	
		}
		else{
			hs.setOldHighScore(loadOldHighScore());
		}
		hsrepo.save(hs);
		return "redirect:/highscore";
	}
	
	
	
	
	public int getOldScore() {
		return oldScore;
	}

	public void setOldScore(int oldScore) {
		this.oldScore = oldScore;
	}

	@RequestMapping(value = "/highscore", method = RequestMethod.GET)
	public String highScores(Model i){
	
		
		List<HighScore> hsList =  hsrepo.findAllByOrderByIdDesc();
		long l = hsList.get(0).getId();
		HighScore hs = hsrepo.findOne(l);
				
		
		//add method to load current highest score out of database
		String name = hs.getName();
		int points = hs.getScore();
		int oldScore = getOldScore();
		
				
		if(points > oldScore){
		
		String bestHighScore = "New best highscore of "+ points + " points by "+ name + " !!!";
		i.addAttribute("bestHighScore", bestHighScore);
		}
		
		else{
		String currentScore = "" + name + " scored "+ points + " points. ";
		i.addAttribute("currentScore", currentScore);
		}
		
		List<HighScore> hsListTop10 = hsrepo.findTop10ByOrderByScoreDesc();
		String nameTop10Array[] = new String[10];
		int scoreTop10Array[] = new int[10];
		for(int j=0; j < 10; j++){
			String nameTop10 = hsListTop10.get(j).getName();
			nameTop10Array[j] = nameTop10;
			System.out.println(nameTop10);
			i.addAttribute("nameTop10Array", nameTop10Array );
		}
		
		for(int j=0; j<10; j++){
			int scoreTop10 = hsListTop10.get(j).getScore();
			scoreTop10Array[j] = scoreTop10;
			System.out.println(scoreTop10);
			i.addAttribute("scoreTop10Array", scoreTop10Array);
		}
		
		
			
		
		
		
		
		
		return "HighScores";
		
	}
	

	
	
		/*public String findName(){//works
			 List<HighScore> hsList = hsrepo.findByScoreOrderByNameAsc(hs.getScore());
			 return (hsList.get(0).getName());
			 }
		
		/*public String findTopScores(){//check
			List<HighScore> hsList = hsrepo.findByScoreOrderByScoreAsc();
			return (hsList.get(0).getName());
		}*/
		
		
		public int loadOldHighScore(){//works
			List<HighScore> hsList = hsrepo.findAllByOrderByOldHighScoreDesc();
			 
			 return hsList.get(0).getOldHighScore();
		}
		
			
			
			

			
			
		
		
		
		
		
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/welcome")
	public @ResponseBody String welcome(){
		return "Hello World";
	}
	
	@RequestMapping("/")
	public @ResponseBody String page1(){
		return "start page";
	}
	
	@RequestMapping("/snack")
	public @ResponseBody String nieuweSnack(){
		
		Snack d = new Snack();
		d.setName("frikandel");
		d.setPrice(1000);
		d.setHealthy(true);
		d.setFatPercent(90);
		
		repo.save(d);
		return "nieuwe snack gemaakt";
	}
		
		
		
		
		@RequestMapping("/drank")
		public @ResponseBody String nieuweDrank(){
			
		Drank a = new Drank();
		a.setName("cola");
		a.setAlcohol(100);
		repos.save(a);
		return "nieuwe drank gemaakt";
	}
		
		
		
		
		
		
		
		
		
	
	
	@RequestMapping("/doei")
	public @ResponseBody String bye(){
		
		return "Bye World";
	}
	
	@RequestMapping("/hello")
	public String overzicht(Model model) {
		model.addAttribute("hoi", "helloooo, world!");
	        return "Hello";
	}
	

}
