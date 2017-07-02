package nl.ycp.demoHighScore;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerGrid {

	@Autowired
	private GridRepository gridrepo;
	
	
	
	
	@RequestMapping(value = "/grid", method = RequestMethod.GET)
	public String saveScorePost(Model g){
		
		
		
		for(int i = 0; i < 8; i++){
		Grid grid = new Grid();
		grid.setColumnA(grid.getToken());
		grid.setColumnB(grid.getToken());
		grid.setColumnC(grid.getToken());
		grid.setColumnD(grid.getToken());
		grid.setColumnE(grid.getToken());
		grid.setColumnF(grid.getToken());
		grid.setColumnG(grid.getToken());
		grid.setColumnH(grid.getToken());
		gridrepo.save(grid);
		}
		
		
		return "redirect:/griddata";
		}
	
	
	boolean playerOneTurn = false;
	boolean playerTwoTurn = false;
	int columnCounterA = 7;
	int columnCounterB = 7;
	int columnCounterC = 7;
	int columnCounterD = 7;
	int columnCounterE = 7;
	int columnCounterF = 7;
	int columnCounterG = 7;
	int columnCounterH = 7;
							
	String ColumnAArray[] = new String[8];
	String ColumnBArray[] = new String[8];
	String ColumnCArray[] = new String[8];
	String ColumnDArray[] = new String[8];
	String ColumnEArray[] = new String[8];
	String ColumnFArray[] = new String[8];
	String ColumnGArray[] = new String[8];
	String ColumnHArray[] = new String[8];
	
	@RequestMapping(value = "/griddata", method = RequestMethod.GET)
	public String saveScore(Model g, Grid grid, HttpServletRequest request){
		
				
		List<Grid> GridListATop10 = gridrepo.findTop10ByOrderByColumnADesc();
		List<Grid> GridListBTop10 = gridrepo.findTop10ByOrderByColumnBDesc();
		List<Grid> GridListCTop10 = gridrepo.findTop10ByOrderByColumnCDesc();
		List<Grid> GridListDTop10 = gridrepo.findTop10ByOrderByColumnDDesc();
		List<Grid> GridListETop10 = gridrepo.findTop10ByOrderByColumnEDesc();
		List<Grid> GridListFTop10 = gridrepo.findTop10ByOrderByColumnFDesc();
		List<Grid> GridListGTop10 = gridrepo.findTop10ByOrderByColumnGDesc();
		List<Grid> GridListHTop10 = gridrepo.findTop10ByOrderByColumnHDesc();
		
		
	if((columnCounterA == 7)&&(columnCounterB == 7)&&(columnCounterC == 7)&&(columnCounterD==7)
			&&(columnCounterE==7)&&(columnCounterF==7)&&(columnCounterG==7)&&(columnCounterH==7)){//initialize grid
		for(int j=0; j < 8; j++){
			String ColumnA = GridListATop10.get(j).getColumnA();
			ColumnAArray[j] = ColumnA;
			System.out.println(ColumnA);
			g.addAttribute("ColumnAArray", ColumnAArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnB = GridListBTop10.get(j).getColumnB();
			ColumnBArray[j] = ColumnB;
			System.out.println(ColumnB);
			g.addAttribute("ColumnBArray", ColumnBArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnC = GridListCTop10.get(j).getColumnC();
			ColumnCArray[j] = ColumnC;
			System.out.println(ColumnC);
			g.addAttribute("ColumnCArray", ColumnCArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnD = GridListDTop10.get(j).getColumnD();
			ColumnDArray[j] = ColumnD;
			System.out.println(ColumnD);
			g.addAttribute("ColumnDArray", ColumnDArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnE = GridListETop10.get(j).getColumnE();
			ColumnEArray[j] = ColumnE;
			System.out.println(ColumnE);
			g.addAttribute("ColumnEArray", ColumnEArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnF = GridListFTop10.get(j).getColumnF();
			ColumnFArray[j] = ColumnF;
			System.out.println(ColumnF);
			g.addAttribute("ColumnFArray", ColumnFArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnG = GridListGTop10.get(j).getColumnG();
			ColumnGArray[j] = ColumnG;
			System.out.println(ColumnG);
			g.addAttribute("ColumnGArray", ColumnGArray );
		}
		
		for(int j=0; j < 8; j++){
			String ColumnH = GridListHTop10.get(j).getColumnH();
			ColumnHArray[j] = ColumnH;
			System.out.println(ColumnH);
			g.addAttribute("ColumnHArray", ColumnHArray );
		}
	}
		
		
		
			if (request.getParameter("buttonA") != null) {
				if(this.columnCounterA >= 0){
					}
				else{
					this.columnCounterA = 7;
					}
				checkPlayerTurn();
				if(playerOneTurn){
				grid.setToken("YYY");
				}
				else{
					grid.setToken("ZZZ");
					System.out.println("in else " + columnCounterA);
				}
				
				//String ColumnA = GridListATop10.get(j).getColumnA();
				String ColA = grid.getToken();
				this.ColumnAArray[this.columnCounterA] = ColA;
				this.columnCounterA--;
				System.out.println(ColA);
				
				updateGrid(g);
			}
			
			//set columnB
			if (request.getParameter("buttonB") != null) {
				if(this.columnCounterB >= 0){
					}
				else{
					this.columnCounterB = 7;
					}
				checkPlayerTurn();
				if(playerOneTurn){
				grid.setToken("YYY");
				}
				else{
					grid.setToken("ZZZ");
					System.out.println("in else " + columnCounterB);
				}
				
				//String ColumnB = GridListATop10.get(j).getColumnB();
				String ColB = grid.getToken();
				this.ColumnBArray[this.columnCounterB] = ColB;
				this.columnCounterB--;
				System.out.println(ColB);
				
				updateGrid(g);
			}
		
		return "Grid";
	}
	
	
			//System.out.println("hello");
			//updateGrid();
		
		
		
	public void checkPlayerTurn(){
		if(playerOneTurn){
			this.playerTwoTurn = true;
			this.playerOneTurn = false;
		}
		else{
			this.playerOneTurn = true;
			this.playerTwoTurn = false;
		}
	}
	
	public void updateGrid(Model g){
		g.addAttribute("ColumnAArray", ColumnAArray );
		g.addAttribute("ColumnBArray", ColumnBArray );
		g.addAttribute("ColumnCArray", ColumnCArray );
		g.addAttribute("ColumnDArray", ColumnDArray );
		g.addAttribute("ColumnEArray", ColumnEArray );
		g.addAttribute("ColumnFArray", ColumnFArray );
		g.addAttribute("ColumnGArray", ColumnGArray );
		g.addAttribute("ColumnHArray", ColumnHArray );
		
	}
	
	
	
	
}
