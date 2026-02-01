package crearComponente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;


public class Advanced_JList<E> extends JList<E> {
	
	private static final long serialVersionUID = 1L;
	private boolean isDesc = true;
	private boolean isActive = true;
	private DefaultListModel<E> modelo = new DefaultListModel<>();

	public Advanced_JList() {
		super();
		setModel(modelo);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listaClicked(e);
			}
		});
	}

	
	public DefaultListModel<E> getModel() {
		return modelo;
	}
	
	private void listaClicked(MouseEvent e) {
		if(!isActive || e.getClickCount()!=2)
			return;
		int index = getSelectedIndex();
		if(index<0)
			return;
		E elemento = modelo.getElementAt(index);
		modelo.remove(index);
		if(isDesc)
			modelo.add(modelo.getSize(), elemento);
		else
			modelo.add(0, elemento);
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isDesplazamientoDesc() {
		return isDesc;
	}
	
	public void setDesplazamientoDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}
}