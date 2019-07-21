package com.js.android.quick.swing.undo;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

/**
 * UndoWrapper is responsible for adding undo and redo support to text
 * components.
 * 
 * @author Antonio Vieiro (antonio@antonioshome.NET), $Author: $
 * @version $Revision: $
 */
public class UndoWrapper implements UndoableEditListener {
	private UndoManager undoManager;
	private UndoAction undoAction;
	private RedoAction redoAction;
	private JTextArea textComponent;

	/**
	 * Creates a new instance of UndoWrapper
	 */
	public UndoWrapper(JTextArea aComponent) {
		textComponent = aComponent;
		undoManager = new UndoManager();
		undoAction = new UndoAction();
		redoAction = new RedoAction();
		textComponent.getDocument().addUndoableEditListener(this);
		textComponent.getInputMap()
				.put((KeyStroke) undoAction.getValue(Action.ACCELERATOR_KEY),
						"恢复");
		textComponent.getInputMap()
				.put((KeyStroke) redoAction.getValue(Action.ACCELERATOR_KEY),
						"重做");
		textComponent.getActionMap().put("恢复", undoAction);
		textComponent.getActionMap().put("重做", redoAction);
	}

	public void undoableEditHappened(UndoableEditEvent e) {
		undoManager.addEdit(e.getEdit());
		undoAction.updateUndoState();
		redoAction.updateRedoState();
	}

	/**
	 * UndoAction is the Action responsible for handling the undo operation.
	 */
	class UndoAction extends AbstractAction {
		public UndoAction() {
			super("Cannot undo"); // TODO: I18N
			setEnabled(false);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undoManager.undo();
			} catch (CannotUndoException cue) {
				// TODO: Use logging?
				cue.printStackTrace(System.err);
			}
			updateUndoState();
			redoAction.updateRedoState();
		}

		void updateUndoState() {
			if (undoManager.canUndo()) {
				setEnabled(true);
				putValue(Action.NAME, "恢复"); // TODO I18N
			} else {
				setEnabled(false);
				putValue(Action.NAME, "不能 恢复"); // TODO I18N
			}
		}
	}

	/**
	 * RedoAction is the Action responsible for handling the redo operation.
	 */
	class RedoAction extends AbstractAction {
		public RedoAction() {
			super("Cannot redo"); // TODO I18N
			setEnabled(false);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Y"));
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undoManager.redo();
			} catch (CannotRedoException cre) {
				// TODO: Use logging?
				cre.printStackTrace(System.err);
			}
			updateRedoState();
			undoAction.updateUndoState();
		}

		void updateRedoState() {
			if (undoManager.canRedo()) {
				setEnabled(true);
				putValue(Action.NAME, "重做"); // TODO I18N
			} else {
				setEnabled(false);
				putValue(Action.NAME, "不能重做"); // TODO I18N
			}
		}
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}
}