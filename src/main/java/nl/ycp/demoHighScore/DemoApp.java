package nl.ycp.demoHighScore;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.ycp.demoHighScore.model.HighScore;
import nl.ycp.demoHighScore.model.HighScoreRepository;

@Controller
public class DemoApp {
	@Autowired
	private HighScoreRepository hsrepo;
	
	private int oldScore;
	
	@RequestMapping(value = "/savescore", method = RequestMethod.GET)
	public String saveScore(Model m){

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
		} else {
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
		} else {
			String currentScore = "" + name + " scored "+ points + " points. ";
			i.addAttribute("currentScore", currentScore);
		}
		
		
		List<HighScore> hsListTop10 = new ArrayList<>();
		
		if(hsrepo.count() <= 10){
			hsListTop10 = hsrepo.findAllByOrderByScoreDesc();
		} else {
			hsListTop10 = hsrepo.findTop10ByOrderByScoreDesc();
		}

		i.addAttribute("hsListTop10", hsListTop10 );
		
	
		return "HighScores";
		
	}

			public int loadOldHighScore(){//works
			List<HighScore> hsList = hsrepo.findAllByOrderByOldHighScoreDesc();
			 
			if(hsList.isEmpty()){
				return 0;
			}
			 return hsList.get(0).getOldHighScore();
		}
}
