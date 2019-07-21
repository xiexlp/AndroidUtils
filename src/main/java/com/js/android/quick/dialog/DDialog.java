package com.js.android.quick.dialog;

import com.js.android.quick.arun.BootstrapTab;
import com.js.android.quick.bean.JavaClassInfo;
import com.js.android.quick.html.Constant;
import com.js.android.quick.html.FileUtil;
import com.js.android.quick.utils.G;
import com.js.android.quick.utils.StringTool;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	VelocityEngine velocityEngine = new VelocityEngine();
	VelocityContext context = new VelocityContext();

	private JTextArea area;

	private BootstrapTab bootstrapTab;

	private JTextField mainFragmentNameTextField;
	private JTextField subFrgamenNameTextField;
	private JTextField mainFragmentDirTextField;
	private JTextField subFragmentDirTextField;
	private JList subFragmentNameList;

	private JButton addSubNameButton;

	private JButton okButton;
	private JButton cancelButton;

	DefaultListModel selectSubModel;
	Data data;

	private String rsString = "";

	private DDialog() {
		super();
		init();
		setModal(true);
		setSize(600, 500);
	}

	public DDialog(BootstrapTab bootstrapTab) {
		super();
		this.bootstrapTab = bootstrapTab;
		init();
		setModal(true);
		setSize(600, 500);
	}

	private void init() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		//c.setLayout(new BorderLayout());
		//area = new JTextArea();
		//c.add(new JScrollPane(area));

		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(500,450));

		GridBagLayout containerLayout=new GridBagLayout();
		//autoJPanel.setPreferredSize(new Dimension(600,400));
		p.setLayout(containerLayout);

		//FlowLayout fl = new FlowLayout();
		//fl.setHgap(15);
		//p.setLayout(fl);

		mainFragmentNameTextField =new JTextField("main");
		subFrgamenNameTextField =new JTextField("sub");
		mainFragmentDirTextField = new JTextField("fragmentmarket");
		subFragmentDirTextField =new JTextField("sub");
		subFragmentNameList =new JList();
		Vector names =new Vector();

		selectSubModel = new DefaultListModel();

		names.add("sub1");
		//subFragmentNameList.setListData(names);
		subFragmentNameList.setModel(selectSubModel);
		subFragmentNameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		subFragmentNameList.setSize(50,30);

		p.add(mainFragmentNameTextField);
		p.add(subFrgamenNameTextField);

		addSubNameButton =new JButton("增加subname");
		addSubNameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("增加sub");
				///names.add(subFrgamenNameTextField.getText());
				selectSubModel.addElement(subFrgamenNameTextField.getText());
				//subFragmentNameList.setListData(names);
				int size = selectSubModel.getSize();
				int[] selectIntArray= new int[size];
				for(int i=0;i<size;i++){
					selectIntArray[i]=i;
					//filePathJList.setS
				}
				//默认文件夹全选
				subFragmentNameList.setSelectedIndices(selectIntArray);
			}
		});

		p.add(addSubNameButton);

		p.add(subFragmentNameList);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("main:"+mainFragmentNameTextField.getText());

				Object[] obs =subFragmentNameList.getSelectedValues();
				List<FragmentName> subFragmentNameList = new ArrayList<>();
				for(Object o:obs){
					System.out.println("o:"+(String)o);
					String n = (String)o;
					FragmentName subFragmentName =new FragmentName();
					subFragmentName.setInstanceName(n);
					subFragmentName.setClassName(StringTool.capitalStr(n));
					subFragmentName.setPackageName(data.getPackageNameTextFieldStr()+"."+mainFragmentDirTextField.getText().trim()+"."+subFragmentDirTextField.getText().trim());
					subFragmentNameList.add(subFragmentName);
				}
				System.out.println("package name:"+data.getPackageNameTextFieldStr());
				BootstrapTab.contentTextArea.setText("packagename from dialog");
				//创建主main fragment
				FragmentName mainFragmentName= new FragmentName();
				mainFragmentName.setInstanceName(mainFragmentNameTextField.getText());
				mainFragmentName.setClassName(StringTool.capitalStr(mainFragmentName.getInstanceName()));
				createMainFragmentAndLayoutCodeFile(mainFragmentName, subFragmentNameList,ConstantDef.MAIN_FRAGMENT);
				//创建多个sub fragment
				for(FragmentName subFragmentName:subFragmentNameList){
					//FragmentName subname = (FragmentName) subFragmentName;
					//System.out.println(subname.getInstanceName());
					createFragmentAndLayoutCodeFile(subFragmentName, ConstantDef.SUB_FRAGMENT);
				}




				//dispose();
			}
		});

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p.add(mainFragmentDirTextField);
		p.add(subFragmentDirTextField);
		p.add(okButton);
		p.add(cancelButton);

		JLabel mainFragmentLabel=new JLabel("主Fragment Name");
		JLabel subFragmentLabel=new JLabel("副subFragment Name");
		JLabel subFragmentListLabel =new JLabel("副fragment Name list");
		JLabel mainFragmentDirLabel = new JLabel("主fragment放入的包");
		JLabel subFragmentDirLabel = new JLabel("副fragment放入的包");
		p.add(mainFragmentLabel);p.add(subFragmentLabel);p.add(subFragmentListLabel);
		p.add(mainFragmentDirLabel);p.add(subFragmentDirLabel);


		containerLayout.setConstraints(mainFragmentLabel, G.nG().aGridXY(0, 0).anchor(G.WEST));
		containerLayout.setConstraints(mainFragmentNameTextField,G.nG().aGridXY(1, 0).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(subFragmentLabel,G.nG().aGridXY(0, 1).anchor(G.WEST));
		containerLayout.setConstraints(subFrgamenNameTextField,G.nG().aGridXY(1, 1).gridWidth(2).anchor(G.EAST).fill(G.HORIZONTAL).weightX(2));
		containerLayout.setConstraints(addSubNameButton,G.nG().aGridXY(3, 1).gridWidth(1).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(subFragmentListLabel,G.nG().aGridXY(0, 2).anchor(G.WEST));
		containerLayout.setConstraints(subFragmentNameList,G.nG().aGridXY(1, 2).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(mainFragmentDirLabel,G.nG().aGridXY(0, 3).anchor(G.WEST));
		containerLayout.setConstraints(mainFragmentDirTextField,G.nG().aGridXY(1, 3).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(subFragmentDirLabel,G.nG().aGridXY(0, 4).anchor(G.WEST));
		containerLayout.setConstraints(subFragmentDirTextField,G.nG().aGridXY(1, 4).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(okButton,G.nG().aGridXY(0, 5).anchor(G.WEST));
		containerLayout.setConstraints(cancelButton,G.nG().aGridXY(1, 5).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		c.add(p);
	}

	private void createMainFragmentAndLayoutCodeFile(FragmentName mainFragmentName, java.util.List<FragmentName> subNameList, int sub){
			doCreateMainFragmentAndLayoutCodeFile(mainFragmentName,subNameList,0);
	}

	private  void doCreateMainFragmentAndLayoutCodeFile(FragmentName mainFragmentName, java.util.List<FragmentName> subNameList, int sub){
		try{
			System.out.println("先跳出个输入框，输入Fragment的名称，必须是NameFragment模式");
			System.out.println("自动生成NameFragment,");
			//String s=mainFragmentNameTextField.getText();
			String s= mainFragmentName.getInstanceName();
			s=s+"Fragment";
			if(!s.endsWith(Constant.FRAGMENT)){
				System.out.println("输入有误，输入名以Fragment结束");
				JOptionPane.showMessageDialog(null,"Fragment输入名尽量名以Fragment结束");
				return;
			}else {
				String javaName = s+".java";
				int indexFragment = javaName.lastIndexOf("Fragment");
				String name = javaName.substring(0,indexFragment);
				System.out.println("驼峰式的名称:"+name);
				String nameUnderLine = StringTool.humpToUnderLine(name);
				System.out.println("驼峰变为下划线:"+nameUnderLine);
				String noSuffixXmlName = "fragment_"+nameUnderLine;
				noSuffixXmlName = noSuffixXmlName.replace("__","_");
				String xmlName = "fragment_"+mainFragmentName.instanceName+".xml";
				//如果有__替换为单下划线
				xmlName = xmlName.replace("__","_");

				System.out.println("Fragment xml名称:"+xmlName);

				String packageName = data.getPackageNameTextFieldStr();
				String className = packageName+"."+s;
				System.out.println("类名:"+className);

				System.out.println("包名:"+packageName);
				//fragment不需要declare
				//String activityDeclare = "<activity android:name=\""+className+"\"/>";
				//contentTextArea.setText("activity声明,放到manifest中:\n"+activityDeclare);

				String packageDir =  packageName.replace(".", "/");
				System.out.println("包名转换之后:"+packageDir);
				String projectDir = data.projectDirTextFieldStr;
				String moduleDir = data.moudleNameTextFieldStr;
				//因为是fragment放在fragment子目录
				String javaDir = projectDir+"\\"+moduleDir+"\\src\\main\\java\\"+packageDir+"\\"+mainFragmentDirTextField.getText().trim();
				String resDir = projectDir+"\\"+moduleDir+"\\src\\main\\res\\layout";

				File javaFile = new File(javaDir);
				File resFile = new File(resDir);

				if(!javaFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					javaFile.mkdirs();
				}else {
					System.out.println("文件夹:"+javaFile.getAbsolutePath()+"存在");
				}
				if(!resFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					resFile.mkdirs();
				}else {
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"存在");
				}

				File javaCodeFile = new File(javaDir+"\\"+StringTool.capitalStr(javaName));
				File xmlCodeFile = new File(resDir+"\\"+xmlName);
				System.out.println("java code file是否存在:"+javaCodeFile.exists());
				//将样板代码内容写入文件
				JavaClassInfo javaClassInfo = new JavaClassInfo();
				javaClassInfo.setFullName(mainFragmentNameTextField.getText().trim());
				javaClassInfo.setPackageName(data.packageNameTextFieldStr.trim()+"."+mainFragmentDirTextField.getText().trim());
				javaClassInfo.setNoSuffixXmlName(noSuffixXmlName);

				if(!javaCodeFile.exists()){
					try {
						System.out.println("java 代码文件不存在,新建一个:"+javaCodeFile.getName());
						javaCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,javaCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");

					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
					javaCodeFile.delete();
					javaCodeFile.createNewFile();
				}
				context.put("jci", javaClassInfo);
				context.put("subNameList",subNameList);
				context.put("subSize",subNameList.size());
				context.put("mainFragmentName",mainFragmentName);
				StringWriter sw = new StringWriter();

				//main
				if(sub==0){
					velocityEngine.mergeTemplate("src/main/resources/templates/main_fragment.vm", "utf-8", context, sw);
				}else if(sub==1){
					velocityEngine.mergeTemplate("src/main/resources/templates/sub_fragment.vm", "utf-8", context, sw);
				}
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw.toString());
				String infoMsg = sw.toString();
				System.out.println("result:"+infoMsg);
				//appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(javaCodeFile,sw.toString());
				System.out.println("xml code file 是否存在:"+xmlCodeFile.exists());
				if(!xmlCodeFile.exists()){
					try {
						System.out.println("xml 代码文件不存在,新建一个:"+xmlCodeFile.getName());
						xmlCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,xmlCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");
					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
						xmlCodeFile.delete();
						xmlCodeFile.createNewFile();
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
				}
				StringWriter sw2 = new StringWriter();

				if(sub==0){
					velocityEngine.mergeTemplate("src/main/resources/templates/main_fragment_layout.vm", "utf-8", context, sw2);
				}else if(sub==1){
					velocityEngine.mergeTemplate("src/main/resources/templates/sub_fragment_layout.vm", "utf-8", context, sw2);
				}

				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw2.toString());
				infoMsg = sw2.toString();
				//appendInfoMsg();
				System.out.println("layout:"+infoMsg);
				//activity程序的内容
				FileUtil.writeToFileClear(xmlCodeFile,sw2.toString());


				StringWriter sw3 = new StringWriter();
				if(sub==0){
					velocityEngine.mergeTemplate("src/main/resources/templates/mainfragment_use.vm", "utf-8", context, sw3);
				}else if(sub==1){
					velocityEngine.mergeTemplate("src/main/resources/templates/mainfragment_use.vm", "utf-8", context, sw3);
				}
				System.out.println(sw3.toString());
				infoMsg = sw3.toString();
				//appendInfoMsg();
				System.out.println("layout111111:"+infoMsg);

				BootstrapTab.contentTextArea.setText("使用:\n"+infoMsg);



			}
		}catch (Exception ee){
			ee.printStackTrace();
		}
	}

	private void createFragmentAndLayoutCodeFile(FragmentName subFragmentName,int sub){

		if(sub==0){
			//main
			doCreateFragmentAndLayoutCodeFile(subFragmentName,0);
		}else if(sub==1){
			//sub
			doCreateFragmentAndLayoutCodeFile(subFragmentName,1);
		}

	}

	private  void doCreateFragmentAndLayoutCodeFile(FragmentName fragmentName,int sub){
		try{
			System.out.println("先跳出个输入框，输入Fragment的名称，必须是NameFragment模式");
			System.out.println("自动生成NameFragment,");
			//String s=mainFragmentNameTextField.getText();
			String s= fragmentName.getInstanceName();
			s=s+"Fragment";
			if(!s.endsWith(Constant.FRAGMENT)){
				System.out.println("输入有误，输入名以Fragment结束");
				JOptionPane.showMessageDialog(null,"Fragment输入名尽量名以Fragment结束");
				return;
			}else {
				String javaName = s+".java";
				int indexFragment = javaName.lastIndexOf("Fragment");
				String name = javaName.substring(0,indexFragment);
				System.out.println("驼峰式的名称:"+name);
				String nameUnderLine = StringTool.humpToUnderLine(name);
				System.out.println("驼峰变为下划线:"+nameUnderLine);
				String noSuffixXmlName = "fragment_"+nameUnderLine;
				noSuffixXmlName = noSuffixXmlName.replace("__","_");
				String xmlName = "fragment_"+fragmentName.instanceName+".xml";
				//如果有__替换为单下划线
				xmlName = xmlName.replace("__","_");

				System.out.println("Fragment xml名称:"+xmlName);

				String packageName = data.getPackageNameTextFieldStr();
				String className = packageName+"."+s;
				System.out.println("类名:"+className);

				System.out.println("包名:"+packageName);
				//fragment不需要declare
				//String activityDeclare = "<activity android:name=\""+className+"\"/>";
				//contentTextArea.setText("activity声明,放到manifest中:\n"+activityDeclare);

				String packageDir =  packageName.replace(".", "/");
				System.out.println("包名转换之后:"+packageDir);
				String projectDir = data.projectDirTextFieldStr;
				String moduleDir = data.moudleNameTextFieldStr;
				String javaDir = projectDir+"\\"+moduleDir+"\\src\\main\\java\\"+packageDir+"\\"+mainFragmentDirTextField.getText().trim()+"\\"+subFragmentDirTextField.getText().trim();
				String resDir = projectDir+"\\"+moduleDir+"\\src\\main\\res\\layout";

				File javaFile = new File(javaDir);
				File resFile = new File(resDir);

				if(!javaFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					javaFile.mkdirs();
				}else {
					System.out.println("文件夹:"+javaFile.getAbsolutePath()+"存在");
				}
				if(!resFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					resFile.mkdirs();
				}else {
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"存在");
				}

				File javaCodeFile = new File(javaDir+"\\"+StringTool.capitalStr(javaName));
				File xmlCodeFile = new File(resDir+"\\"+xmlName);
				System.out.println("java code file是否存在:"+javaCodeFile.exists());
				//将样板代码内容写入文件
				JavaClassInfo javaClassInfo = new JavaClassInfo();
				javaClassInfo.setFullName(mainFragmentNameTextField.getText().trim());
				javaClassInfo.setPackageName(data.packageNameTextFieldStr.trim()+"."+mainFragmentDirTextField.getText()+"."+subFragmentDirTextField.getText());
				javaClassInfo.setNoSuffixXmlName(noSuffixXmlName);

				if(!javaCodeFile.exists()){
					try {
						System.out.println("java 代码文件不存在,新建一个:"+javaCodeFile.getName());
						javaCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,javaCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");

					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
					javaCodeFile.delete();
					javaCodeFile.createNewFile();
				}
				context.put("jci", javaClassInfo);
				context.put("fragmentName",fragmentName);
				StringWriter sw = new StringWriter();

				//main
				if(sub==0){
					velocityEngine.mergeTemplate("src/main/resources/templates/main_fragment.vm", "utf-8", context, sw);
				}else if(sub==1){
					velocityEngine.mergeTemplate("src/main/resources/templates/sub_fragment.vm", "utf-8", context, sw);
				}
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw.toString());
				String infoMsg = sw.toString();
				System.out.println("result:"+infoMsg);
				//appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(javaCodeFile,sw.toString());
				System.out.println("xml code file 是否存在:"+xmlCodeFile.exists());
				if(!xmlCodeFile.exists()){
					try {
						System.out.println("xml 代码文件不存在,新建一个:"+xmlCodeFile.getName());
						xmlCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,xmlCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");
					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
						xmlCodeFile.delete();
						xmlCodeFile.createNewFile();
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
				}
				StringWriter sw2 = new StringWriter();

				if(sub==0){
					velocityEngine.mergeTemplate("src/main/resources/templates/main_fragment_layout.vm", "utf-8", context, sw2);
				}else if(sub==1){
					velocityEngine.mergeTemplate("src/main/resources/templates/sub_fragment_layout.vm", "utf-8", context, sw2);
				}

				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw2.toString());
				infoMsg = sw2.toString();
				//appendInfoMsg();
				System.out.println("layout:"+infoMsg);
				//activity程序的内容
				FileUtil.writeToFileClear(xmlCodeFile,sw2.toString());
			}
		}catch (Exception ee){
			ee.printStackTrace();
		}
	}

	public static String showDialog(Component relativeTo, Data data) {
		DDialog d = new DDialog();
		d.data = data;
		//d.area.setText(text);
		//d.rsString = text;
		d.setLocationRelativeTo(relativeTo);
		d.setModal(false);
		d.setVisible(true);
		return "1";
	}

	public static String showDialog(Component relativeTo, String datastr) {
		DDialog d = new DDialog();
//		d.data = data;
		//d.area.setText(text);
		//d.rsString = text;
		d.setLocationRelativeTo(relativeTo);
		d.setVisible(true);
		return datastr;
	}

}

