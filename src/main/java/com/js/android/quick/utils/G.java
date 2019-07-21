package com.js.android.quick.utils;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class G extends GridBagConstraints {
	
	public static G g() {
		return new G();
	}
	
	public static G n() {
		return new G();
	}
	
	public static G nG() {
		return new G();
	}

	public G() {
	} 

	public G gridXY(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
		return this;
	}
	
	public G grid1X1Y(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
		return this;
	}
	
	public G aGridXY(int x, int y) {
		this.gridx = x;
		this.gridy = y;
		return this;
	}

	public G gridX(int gridx) {
		this.gridx = gridx;
		return this;
	}

	public G gridY(int gridy) {
		this.gridy = gridy;
		return this;
	}

	// ��ʼ�����Ͻ�λ��
	public G(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}

	// ��ʼ�����Ͻ�λ�ú���ռ����������
	public G(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}

	public G gridWidth(int gridwidth) {
		this.gridwidth = gridwidth;
		return this;
	}
	
	public G agridWidth(int gridwidth) {
		this.gridwidth = gridwidth;
		return this;
	}
	
	public G agw(int gridwidth) {
		this.gridwidth = gridwidth;
		return this;
	}
	
	public G gridHeight(int gridheight) {
		this.gridheight = gridheight;
		return this;
	}
	
	public G agridHeight(int gridheight) {
		this.gridheight = gridheight;
		return this;
	}

	public G agh(int gridheight) {
		this.gridheight = gridheight;
		return this;
	}

	public G gridWidthAndHeight(int gridwidth, int gridheight) {
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		return this;
	}

	// ���뷽ʽ
	public G anchor(int anchor) {
		this.anchor = anchor;
		return this;
	}
	

	// �Ƿ����켰���췽��
	public G afill(int fill) {
		this.fill = fill;
		return this;
	}
	
	public G fill(int fill) {
		this.fill = fill;
		return this;
	}

	// x��y�����ϵ�����
	public G weight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	public G aweight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	
	public G weightX(double weightx) {
		this.weightx = weightx;
		return this;
	}
	
	public G awx(double weightx) {
		this.weightx = weightx;
		return this;
	}
	
	public G aweightX(double weightx) {
		this.weightx = weightx;
		return this;
	}
	
	public G weightY(double weighty) {
		this.weighty = weighty;
		return this;
	}
	
	public G awy(double weighty) {
		this.weighty = weighty;
		return this;
	}
	
	public G aweightY(double weighty) {
		this.weighty = weighty;
		return this;
	}

	// �ⲿ���
	public G insets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	public G ainsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	// �����
	public G insets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}
	
	public G ainsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}
	
	public G ai(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	// �����
	public G ipad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
	
	public G aipad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}

	public G ipadX(int ipadx) {
		this.ipadx = ipadx;
		return this;
	}
	
	public G aipadX(int ipadx) {
		this.ipadx = ipadx;
		return this;
	}

	public G ipadY(int ipady) {
		this.ipady = ipady;
		return this;
	}
	
	public G aipadY(int ipady) {
		this.ipady = ipady;
		return this;
	}
	
	public G defaultG(){
		this.gridx=0;
		this.gridy=0;
		this.gridheight=1;
		this.gridwidth=1;
		this.anchor=G.CENTER;
		this.insets=new Insets(0, 0, 0, 0);
		this.ipadx=0;
		this.ipady=0;
		return this;
	}
	
	public G clear(){
		this.gridx=0;
		this.gridy=0;
		this.gridheight=1;
		this.gridwidth=1;
		this.anchor=G.CENTER;
		this.insets=new Insets(0, 0, 0, 0);
		this.ipadx=0;
		this.ipady=0;
		return this;
	}
}