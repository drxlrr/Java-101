package ph.com.bpi.M2;

public class Act1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book Book = new Book();
		Tree dispTree = new Tree();
		House dispHouse = new House();
		
		Book.title = "Game of Thrones";
		Book.classification = "Fiction";
		dispTree.treeName = "Alugbati";
		dispTree.treeType = "Herbal Tree";
		dispHouse.houseNumber = 101;
		dispHouse.houseType = "single";
		
		
		Book.DisplayBook();
		dispTree.displayTrees();
		dispHouse.displayHouse();
	}

}
