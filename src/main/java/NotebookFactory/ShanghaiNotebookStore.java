package NotebookFactory;

public class ShanghaiNotebookStore extends NotebookStore{

	@Override
	Notebook createNotebook(String type) {
		Notebook notebook = null;
		if ("gaming".equals(type)) {
			notebook = new ChineseAsusROG();
		} else if ("programming".equals(type)) {
			notebook = new ChineseThinkPad();
		} else if ("fun".equals(type)) {
			notebook = new ChineseMcBook();
		}
		return notebook;
	}

}
