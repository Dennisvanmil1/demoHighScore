package nl.ycp.demohighscore;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import nl.ycp.demoHighScore.model.HighScore;
import nl.ycp.demoHighScore.model.HighScoreRepository;

@Controller
public class HighSoceController {
	@Autowired
	private HighScoreRepository hsRepo;

	private int oldScore;


	@GetMapping("/savescore")
	public String saveScore(Model m){

		return "SaveScore";
		}

	@PostMapping("/savescore")
	public String saveScorePost(String name, int score, HttpServletRequest request){

		HighScore hs = new HighScore();
//		String name = request.getParameter("name");
//		int score = Integer.parseInt(request.getParameter("score"));
		setOldScore(loadOldHighScore());
		hs.setScore(score);
		hs.setName(name);
		if(score > this.oldScore) {
			hs.setOldHighScore(score);
		} else {
			hs.setOldHighScore(loadOldHighScore());
		}
		hsRepo.save(hs);
		return "redirect:/highscore";
	}

	public int getOldScore() {
		return oldScore;
	}

	public void setOldScore(int oldScore) {
		this.oldScore = oldScore;
	}

	@GetMapping("/highscore")
	public String highScores(Model i){


		List<HighScore> hsList =  hsRepo.findAllByOrderByIdDesc();
		long l = hsList.get(0).getId();
		HighScore hs = hsRepo.findOne(l);

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

		List<HighScore> hsListTop10 = hsRepo.findTop10ByOrderByScoreDesc();
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

		public int loadOldHighScore(){//works
			List<HighScore> hsList = hsRepo.findAllByOrderByOldHighScoreDesc();

			 return hsList.get(0).getOldHighScore();
		}
}
