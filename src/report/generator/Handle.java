/*
 * Compliancy!
 */
package report.generator;

import java.io.*;
import java.util.*;

import javafx.scene.web.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.print.*;
import javafx.collections.*;

/**
 *
 * @author Seumx Plus
 */

public class Handle {
    
    private Stage stio; private String cont;
    
    /**
     * Initializer
     */
    public Handle()
    {
        
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void generate(Properties details, Properties midf, Properties mids, Properties finf, Properties fins,
            Properties agg, Properties remark, Properties sign, WebView web) throws IOException  {
        
        //generate totals form pr
        midf.put("total","0"); mids.put("total","0"); finf.put("total","0"); fins.put("total","0");
        
        
        //mid fulls
        Set set=midf.keySet(); Iterator it=set.iterator(); int mf=0; 
        
        List<String> lst=new ArrayList(); List<String> lst1=new ArrayList();
        List<String> lst2=new ArrayList(); List<String> lst3=new ArrayList();
        
        while(it.hasNext()) {
            lst.add(it.next().toString());
        }
        System.out.println(lst);
        
        for(int i=0; i<lst.size(); i++){ System.out.println(midf.getProperty(lst.get(i))+"\n"+mf);
            if(!midf.getProperty(lst.get(i)).equals(" ")) {
           mf=mf+Integer.valueOf(midf.getProperty(lst.get(i))); }
        }
        
        
        midf.put("total", String.valueOf(mf)); put(midf, "agg", " "); put(midf,"pos"," ");
        
        //mid scores
        Set set1=mids.keySet(); Iterator it1=set1.iterator(); int ms=0;
        
        while(it1.hasNext()) {
            lst1.add(it1.next().toString());
        }
        System.out.println(lst1);
        
        for(int i=0; i<lst1.size(); i++){ System.out.println(mids.getProperty(lst1.get(i))+"\n"+ms);
            if(!mids.getProperty(lst1.get(i)).equals(" ")) {
           ms=ms+Integer.valueOf(mids.getProperty(lst1.get(i))); }
        }
        
        if(!mids.getProperty("agg").equals(" ") && !mids.getProperty("pos").equals(" ")) {
        ms=ms-Integer.valueOf(mids.getProperty("agg")); ms=ms-Integer.valueOf(mids.getProperty("pos"));}
        
        mids.put("total", String.valueOf(ms));
        
        //final report
        //final full
        Set set2=finf.keySet(); Iterator it2=set2.iterator(); int ff=0;
        
        while(it2.hasNext()) {
            lst2.add(it2.next().toString());
        }
        System.out.println(lst2);
        
        for(int i=0; i<lst2.size(); i++){ System.out.println(finf.getProperty(lst2.get(i))+"\n"+ff);
            if(!finf.getProperty(lst2.get(i)).equals(" ")) {
           ff=ff+Integer.valueOf(finf.getProperty(lst2.get(i))); }
        }
        
        finf.put("total", String.valueOf(ff));
        
        //final score
        Set set3=fins.keySet(); Iterator it3=set3.iterator(); int fs=0;
        
        while(it3.hasNext()) {
            lst3.add(it3.next().toString());
        }
        System.out.println(lst3);
        
        for(int i=0; i<lst3.size(); i++){ System.out.println(fins.getProperty(lst3.get(i))+"\n"+fs);
            if(!fins.getProperty(lst3.get(i)).equals(" ")) {
           fs=fs+Integer.valueOf(fins.getProperty(lst3.get(i))); }
        }
        
        fins.put("total", String.valueOf(fs));
        
        
        //Here is the real generation of the report doc.
        String report="<html><head><title>Report</title></head><body background=\"bgs/bg2.png\">\n"
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\">\n"
                + "<table border=\"13\" bordercolor=\"navy\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th>\n"
                + "<table border=\"0\" bordercolor=\"darkslategrey\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th><img src=\"cof.jpg\" width=\"71\" height=\"71\" alt=\"LOGO\"/> </th> </tr> <br/>\n"
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>MINISTRY OF EDUCATION AND SPORTS</b></font></th></tr>\n"
                + "<tr><th><font face=\"Algerian\" size=\"+3\" color=\"navy\"><b>"+details.getProperty("sch")+"</b></font></th></tr>\n"
                
                + "<tr><th><table border=\"0\" bordercolor=\"darkslategrey\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th><img src=\"bgs/sch.png\" width=\"147\" height=\"147\" alt=\"LOGO\"/></th>"
                + "<th><font face=\"Cambria\" size=\"+1\" color=\"black\"><b><i>\""+details.getProperty("motto")+"\"</i></b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>"+details.getProperty("box")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkred\"><b>"+details.getProperty("term")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkgreen\"><b>"+details.getProperty("pname")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>"+details.getProperty("class")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>Position: "+details.getProperty("pos")+" Out Of \n"
                + ""+details.getProperty("out")+"</b></font></th>"
                
                + "<th><img src=\"bgs/smx.png\" width=\"147\" height=\"147\" alt=\"LOGO\"/></th> </tr></table></th></tr>\n"
                
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+1\" color=\"darkslategrey\"><b>MID-TERM PERFORMANCE</b></font></th></tr>\n"
                
                + "<tr><th>\n"
                + "<table border=\"1\" bordercolor=\"navy\" cellpadding=\"2\" cellspacing=\"2\" bgcolor=\"lightgrey\" width=\"731\">\n"
                + "<tr><th>ENG</th><th>MATHS</th><th>SCI</th><th>S.S.T</th><th>LIT I</th><th>LIT II</th><th>R.E</th><th>READ</th>\n"
                + "<th>L.L</th><th>ART & CRAFT</th><th>AGG</th><th>TOTAL</th><th>POSITION</th></tr>\n"
                
                + "<tr><th>"+midf.getProperty("eng")+"</th><th>"+midf.getProperty("math")+"</th><th>"+midf.getProperty("scie")+"</th>\n"
                + "<th>"+midf.getProperty("sst")+"</th>\n"
                + "<th>"+midf.getProperty("lt1")+"</th><th>"+midf.getProperty("lt2")+"</th>\n"
                + "<th>"+midf.getProperty("re")+"</th><th>"+midf.getProperty("red")+"</th>\n"
                + "<th>"+midf.getProperty("loc")+"</th><th>"+midf.getProperty("art")+"</th>\n"
                + "<th>"+midf.getProperty("agg")+"</th><th>"+midf.getProperty("total")+"</th><th>"+midf.getProperty("pos")+"</th></tr>\n"
                
                + "<tr><th>"+mids.getProperty("eng")+"</th><th>"+mids.getProperty("math")+"</th><th>"+mids.getProperty("scie")+"</th>\n"
                + "<th>"+mids.getProperty("sst")+"</th>\n"
                + "<th>"+mids.getProperty("lt1")+"</th><th>"+mids.getProperty("lt2")+"</th>\n"
                + "<th>"+mids.getProperty("re")+"</th><th>"+mids.getProperty("red")+"</th>\n"
                + "<th>"+mids.getProperty("loc")+"</th><th>"+mids.getProperty("art")+"</th>\n"
                + "<th>"+mids.getProperty("agg")+"</th><th>"+mids.getProperty("total")+"</th><th>"+mids.getProperty("pos")+"</th></tr>\n"
                
                + "</table> </th></tr>\n"
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+1\" color=\"navy\"><b>TERMLY PERFORMANCE</b></font></th></tr>\n"
                
                + "<tr><th>\n"
                + "<table border=\"1\" bordercolor=\"navy\" cellpadding=\"2\" cellspacing=\"2\" bgcolor=\"lightgrey\" width=\"731\">\n"
                //+ "<font face=\"Cambria\" size=\"+0\" color=\"black\">"
                + "<tr><th><b>SUBJECT</b></th><th><b>FULL MARKS</b></th><th><b>MARKS OBTAINED</b></th>\n"
                + "\n<th><b>AGG</b></th><th><b>REMARKS</b></th><th><b>TEACHER'S SIGN</b></th></tr>\n"
                
                + "<tr><th>ENGLISH</th><th>"+finf.getProperty("eng")+"</th><th>"+fins.getProperty("eng")+"</th><th>"+agg.getProperty("eng")
                + "\n</th><th>"+remark.getProperty("eng")+"</th><th>"+sign.getProperty("eng")+"</th></tr>\n"
                
                + "<tr><th>MATHEMATICS</th><th>"+finf.getProperty("math")+"</th><th>"+fins.getProperty("math")+"</th><th>"+agg.getProperty("math")
                + "\n</th><th>"+remark.getProperty("math")+"</th><th>"+sign.getProperty("math")+"</th></tr>\n"
                
                + "<tr><th>SCIENCE</th><th>"+finf.getProperty("scie")+"</th><th>"+fins.getProperty("scie")+"</th><th>"+agg.getProperty("scie")
                + "\n</th><th>"+remark.getProperty("scie")+"</th><th>"+sign.getProperty("scie")+"</th></tr>\n"
                
                + "<tr><th>SOCIAL STUDIES</th><th>"+finf.getProperty("sst")+"</th><th>"+fins.getProperty("sst")+"</th><th>"+agg.getProperty("sst")
                + "\n</th><th>"+remark.getProperty("sst")+"</th><th>"+sign.getProperty("sst")+"</th></tr>\n"
                
                + "<tr><th>LITERACY I</th><th>"+finf.getProperty("lt1")+"</th><th>"+fins.getProperty("lt1")+"</th><th>"+agg.getProperty("lt1")
                + "\n</th><th>"+remark.getProperty("lt1")+"</th><th>"+sign.getProperty("lt1")+"</th></tr>\n"
                
                + "<tr><th>LITERACY II</th><th>"+finf.getProperty("lt2")+"</th><th>"+fins.getProperty("lt2")+"</th><th>"+agg.getProperty("lt2")
                + "\n</th><th>"+remark.getProperty("lt2")+"</th><th>"+sign.getProperty("lt2")+"</th></tr>\n"
                
                + "<tr><th>RELIGIOUS EDUCATION</th><th>"+finf.getProperty("re")+"</th><th>"+fins.getProperty("re")+"</th><th>"+agg.getProperty("re")
                + "\n</th><th>"+remark.getProperty("re")+"</th><th>"+sign.getProperty("re")+"</th></tr>\n"
                
                + "<tr><th>READING</th><th>"+finf.getProperty("red")+"</th><th>"+fins.getProperty("red")+"</th><th>"+agg.getProperty("red")
                + "\n</th><th>"+remark.getProperty("red")+"</th><th>"+sign.getProperty("red")+"</th></tr>\n"
                
                + "<tr><th>LOCAL LANGUAGE</th><th>"+finf.getProperty("loc")+"</th><th>"+fins.getProperty("loc")+"</th><th>"+agg.getProperty("loc")
                + "\n</th><th>"+remark.getProperty("loc")+"</th><th>"+sign.getProperty("loc")+"</th></tr>\n"
                
                + "<tr><th>ART & CRAFT</th><th>"+finf.getProperty("art")+"</th><th>"+fins.getProperty("art")+"</th><th>"+agg.getProperty("art")
                + "\n</th><th>"+remark.getProperty("art")+"</th><th>"+sign.getProperty("art")+"</th> </tr>\n"
                
                + "<tr><th>TOTAL</th><th>"+finf.getProperty("total")+"</th><th>"+fins.getProperty("total")+"</th><th>"+agg.getProperty("total")
                + "\n</th><th> </th><th> </th> </tr></table></th></tr>\n"
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>Conduct.............................................."
                + ".................Health...................................Attendance..................................</b></font></th></tr>\n"
                
                +"<tr><th><p/><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>Class Teacher's Report\n"
                + "........................................................................"
                + "....................................................................<br/>\n"
                + "...................................................................................."
                + "..........................................Signature......................................</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+1\" color=\"purple\"><b>SCHOOL REQUIREMENTS</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b> A) Meals: <u>"+details.getProperty("meal")+"</u>\n"
                + " B) Exercise books: <u>"+details.getProperty("book")+"</u></b></font>\n"
                
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\"><b> C) Pens: <u>"+details.getProperty("pen")+"</u>\n"
                + "<br/> D) Operation Fund: <u>"+details.getProperty("fund")+"</u></b></font>\n"
                
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\"><b> E) M.T.C Set:<u>"+details.getProperty("set")+"</u>\n"
                + "</b></font> </th></tr>"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"navy\"><b>NEXT TERM BEGINS ON___"+details.getProperty("nexts")+"___ and \n"
                + "Ends on___"+details.getProperty("nexte")+"</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>HEADTEACHER'S COMMENT\n"
                + "....................................................................................................<BR/>\n"
                + "................................................................................................"
                + "SIGNATURE............................................"
                + "</b></font></th></tr>\n"
                
                + "<tr><th></th></tr> <tr><th><i>\"Invalid without a school stamp\"</i>\n"
                + "<i><b>______________________Powered by Seumx Plus</b></i>\n"
                + "</th></tr>\n";
                
        
        
        //completing report
        report=report+"</table></table></font></body></html>"; cont=report;
        
        //write report to temp file
        File f=new File("temp.html");
        FileWriter wrt=new FileWriter(f);
        wrt.write(report); wrt.flush(); wrt.close();
        
        web.getEngine().load(f.toURI().toURL().toString());
        
    }
    
    @SuppressWarnings({"ManualArrayToCollectionCopy", "ConvertToTryWithResources"})
    public void showReport(WebView view, Stage Stage, Image im, String pname) {
        
        //showing the report
        view.setPrefHeight(1379); view.setPrefWidth(1379);
        
        Button prt=new Button("Print"); prt.setPrefWidth(700); prt.setPrefHeight(40);
        prt.setStyle("-fx-background-color:navy; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        
        Button sv=new Button("Save"); sv.setPrefWidth(700); sv.setPrefHeight(40);
        sv.setStyle("-fx-background-color:navy; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        
        GridPane p=new GridPane(); p.setPadding(new Insets(3,3,3,3)); p.setVgap(3); p.setHgap(3);
        p.setAlignment(Pos.CENTER); p.setStyle("-fx-background-color:darkslategrey"); p.add(sv,0,0); p.add(prt,1,0);
        
        GridPane i=new GridPane(); i.setPadding(new Insets(7,7,7,7)); i.setAlignment(Pos.TOP_CENTER);
        i.setVgap(7); i.setHgap(7); i.setStyle("-fx-background-color:white"); i.add(view,0,0); i.add(p,0,1);
        
        prt.setOnMouseMoved(ev->{
            prt.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        });
        prt.setOnMouseExited(ev->{
            prt.setStyle("-fx-background-color:navy; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        });
        
        sv.setOnMouseMoved(ev->{
            sv.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        });
        sv.setOnMouseExited(ev->{
            sv.setStyle("-fx-background-color:navy; -fx-text-fill:azure; -fx-font:bold 16px 'Cambria'");
        });
        
        prt.setOnAction(ev->{
            
            PrinterJob job=PrinterJob.createPrinterJob();
            
            if(job!=null & job.showPrintDialog(Stage)) {
                
                view.getEngine().print(job); 
                job.endJob();
                
                if(stio!=null) {
                    stio.close();
                }
            }
            
            
        });
        
        sv.setOnAction(evio->{
            
            //get cluster
            File silas=new File("Cluster");
            String[] esther=silas.list();
            
            List<String> po=new ArrayList();
            
            //adding
            for(String coi:esther) {
                po.add(coi);
            }
            
            //create view
            Button save=new Button("Save To Selected Cluster"); save.setDisable(true); save.setPrefWidth(918);
            save.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:navy;");
            
            ObservableList<String> obr=FXCollections.observableArrayList(po); ListView lvy=new ListView(obr);
            lvy.setStyle("-fx-control-inner-background:darkslateblue; -fx-font:normal 16px 'Cambria'; -fx-accent: white;"); lvy.setPrefSize(1000,1000);
            
            GridPane eq=new GridPane(); eq.setPadding(new Insets(5,5,5,5)); eq.setVgap(7); eq.setHgap(7);
            eq.setAlignment(Pos.CENTER); eq.setStyle("-fx-background-color:white"); eq.add(lvy,0,0); eq.add(save,0,1);
            
            lvy.setOnMouseClicked(rei->{
                
                if(rei.getClickCount()==1) {
                    save.setDisable(false);
                }
                
            });
            
            save.setOnAction(tr->{
                try {
                //getCluster
                String plm=lvy.getSelectionModel().getSelectedItem().toString();
                
                //read
                FileInputStream in1=new FileInputStream(silas+"/"+plm+"/data.bat");
                ObjectInputStream in=new ObjectInputStream(in1);
                Properties qwe=(Properties) in.readObject();
                
                //see if the file exists
                Set s=qwe.keySet(); Iterator iy=s.iterator(); boolean exist=true;
                while(iy.hasNext()) 
                {
                    String nam=iy.next().toString();
                    if(pname.equals(nam)) 
                    {
                        exist=false;
                    }
                }
                
                if(exist)
                {
                qwe.put(pname, cont);
                
                //write
                FileOutputStream out=new FileOutputStream(silas+"/"+plm+"/data.bat");
                ObjectOutputStream iol=new ObjectOutputStream(out);
                iol.writeObject(qwe); iol.flush(); iol.close();
                
                stio.close();
                
                }
                
                } catch(IOException | ClassNotFoundException exi) {
                    System.out.println(exi.getMessage());
                }
            });
            
            //show
                if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Save report"); stio.getIcons().add(im); stio.setScene(new Scene(eq));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Save report"); stio.getIcons().add(im); stio.setScene(new Scene(eq));
                stio.initOwner(Stage); stio.show();
            }
                
            
        });
        
        if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Generated Report"); stio.getIcons().add(im); stio.setScene(new Scene(i));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Generated Report"); stio.getIcons().add(im); stio.setScene(new Scene(i));
                stio.initOwner(Stage); stio.show();
            }
        
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void generateU(Properties details, Properties midf, Properties mids, Properties finf, Properties fins,
            Properties agg, Properties remark, Properties sign, WebView web) throws IOException  {
        
        //generate totals form pr
        midf.put("total","0"); mids.put("total","0"); finf.put("total","0"); fins.put("total","0");
        
        
        //mid fulls
        Set set=midf.keySet(); Iterator it=set.iterator(); int mf=0; 
        
        List<String> lst=new ArrayList(); List<String> lst1=new ArrayList();
        List<String> lst2=new ArrayList(); List<String> lst3=new ArrayList();
        
        while(it.hasNext()) {
            lst.add(it.next().toString());
        }
        System.out.println(lst);
        
        for(int i=0; i<lst.size(); i++){ System.out.println(midf.getProperty(lst.get(i))+"\n"+mf);
            if(!midf.getProperty(lst.get(i)).equals(" ")) {
           mf=mf+Integer.valueOf(midf.getProperty(lst.get(i))); }
        }
        
        
        midf.put("total", String.valueOf(mf)); put(midf, "agg", " "); put(midf,"pos"," ");
        
        //mid scores
        Set set1=mids.keySet(); Iterator it1=set1.iterator(); int ms=0;
        
        while(it1.hasNext()) {
            lst1.add(it1.next().toString());
        }
        System.out.println(lst1);
        
        for(int i=0; i<lst1.size(); i++){ System.out.println(mids.getProperty(lst1.get(i))+"\n"+ms);
            if(!mids.getProperty(lst1.get(i)).equals(" ")) {
           ms=ms+Integer.valueOf(mids.getProperty(lst1.get(i))); }
        }
        
        if(!mids.getProperty("agg").equals(" ") && !mids.getProperty("pos").equals(" ")) {
        ms=ms-Integer.valueOf(mids.getProperty("agg")); ms=ms-Integer.valueOf(mids.getProperty("pos"));}
        
        mids.put("total", String.valueOf(ms));
        
        //final report
        //final full
        Set set2=finf.keySet(); Iterator it2=set2.iterator(); int ff=0;
        
        while(it2.hasNext()) {
            lst2.add(it2.next().toString());
        }
        System.out.println(lst2);
        
        for(int i=0; i<lst2.size(); i++){ System.out.println(finf.getProperty(lst2.get(i))+"\n"+ff);
            if(!finf.getProperty(lst2.get(i)).equals(" ")) {
           ff=ff+Integer.valueOf(finf.getProperty(lst2.get(i))); }
        }
        
        finf.put("total", String.valueOf(ff));
        
        //final score
        Set set3=fins.keySet(); Iterator it3=set3.iterator(); int fs=0;
        
        while(it3.hasNext()) {
            lst3.add(it3.next().toString());
        }
        System.out.println(lst3);
        
        for(int i=0; i<lst3.size(); i++){ System.out.println(fins.getProperty(lst3.get(i))+"\n"+fs);
            if(!fins.getProperty(lst3.get(i)).equals(" ")) {
           fs=fs+Integer.valueOf(fins.getProperty(lst3.get(i))); }
        }
        
        fins.put("total", String.valueOf(fs));
        
        
        //Here is the real generation of the report doc.
        String report="<html><head><title>Report</title></head><body background=\"bgs/bg2.png\">\n"
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\">\n"
                + "<table border=\"13\" bordercolor=\"navy\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th>\n"
                + "<table border=\"0\" bordercolor=\"darkslategrey\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th><img src=\"cof.jpg\" width=\"71\" height=\"71\" alt=\"LOGO\"/> </th> </tr> <br/>\n"
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>MINISTRY OF EDUCATION AND SPORTS</b></font></th></tr>\n"
                + "<tr><th><font face=\"Algerian\" size=\"+3\" color=\"navy\"><b>"+details.getProperty("sch")+"</b></font></th></tr>\n"
                
                + "<tr><th><table border=\"0\" bordercolor=\"darkslategrey\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"white\" width=\"731\">\n"
                + "<tr><th><img src=\"bgs/sch.png\" width=\"147\" height=\"147\" alt=\"LOGO\"/></th>"
                + "<th><font face=\"Cambria\" size=\"+1\" color=\"black\"><b><i>\""+details.getProperty("motto")+"\"</i></b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>"+details.getProperty("box")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkred\"><b>"+details.getProperty("term")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkgreen\"><b>"+details.getProperty("pname")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>"+details.getProperty("class")+"</b></font><br/>\n"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"><b>Position: "+details.getProperty("pos")+" Out Of \n"
                + ""+details.getProperty("out")+"</b></font></th>"
                
                + "<th><img src=\"bgs/smx.png\" width=\"147\" height=\"147\" alt=\"LOGO\"/></th> </tr></table></th></tr>\n"
                
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+1\" color=\"darkslategrey\"><b>MID-TERM PERFORMANCE</b></font></th></tr>\n"
                
                + "<tr><th>\n"
                + "<table border=\"1\" bordercolor=\"navy\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"lightgrey\" width=\"731\">\n"
                + "<tr><th>ENG</th><th>MATHS</th><th>SCI</th><th>S.S.T</th><th>R.E</th>"
                /*+ "<th>LIT I</th><th>LIT II</th><th>READ</th>\n"
                + "<th>L.L</th><th>ART & CRAFT</th>"*/
                + "<th>AGG</th><th>TOTAL</th><th>POSITION</th></tr>\n"
                
                + "<tr><th>"+midf.getProperty("eng")+"</th><th>"+midf.getProperty("math")+"</th><th>"+midf.getProperty("scie")+"</th>\n"
                + "<th>"+midf.getProperty("sst")+"</th>\n"
                //+ "<th>"+midf.getProperty("lt1")+"</th><th>"+midf.getProperty("lt2")+"</th>\n"
                + "<th>"+midf.getProperty("re")+"</th>"//><th>"+midf.getProperty("red")+"</th>\n"
                //+ "<th>"+midf.getProperty("loc")+"</th><th>"+midf.getProperty("art")+"</th>\n"
                + "<th>"+midf.getProperty("agg")+"</th><th>"+midf.getProperty("total")+"</th><th>"+midf.getProperty("pos")+"</th></tr>\n"
                
                + "<tr><th>"+mids.getProperty("eng")+"</th><th>"+mids.getProperty("math")+"</th><th>"+mids.getProperty("scie")+"</th>\n"
                + "<th>"+mids.getProperty("sst")+"</th>\n"
                //+ "<th>"+mids.getProperty("lt1")+"</th><th>"+mids.getProperty("lt2")+"</th>\n"
                + "<th>"+mids.getProperty("re")+"</th>"//+"</th><th>"+mids.getProperty("red")+"</th>\n"
                //+ "<th>"+mids.getProperty("loc")+"</th><th>"+mids.getProperty("art")+"</th>\n"
                + "<th>"+mids.getProperty("agg")+"</th><th>"+mids.getProperty("total")+"</th><th>"+mids.getProperty("pos")+"</th></tr>\n"
                
                + "</table> </th></tr>\n"
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+1\" color=\"navy\"><b>TERMLY PERFORMANCE</b></font></th></tr>\n"
                
                + "<tr><th>\n"
                + "<table border=\"1\" bordercolor=\"navy\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"lightgrey\" width=\"731\">\n"
                //+ "<font face=\"Cambria\" size=\"+0\" color=\"black\">"
                + "<tr><th><b>SUBJECT</b></th><th><b>FULL MARKS</b></th><th><b>MARKS OBTAINED</b></th>\n"
                + "\n<th><b>AGG</b></th><th><b>REMARKS</b></th><th><b>TEACHER'S SIGN</b></th></tr>\n"
                
                + "<tr><th>ENGLISH</th><th>"+finf.getProperty("eng")+"</th><th>"+fins.getProperty("eng")+"</th><th>"+agg.getProperty("eng")
                + "\n</th><th>"+remark.getProperty("eng")+"</th><th>"+sign.getProperty("eng")+"</th></tr>\n"
                
                + "<tr><th>MATHEMATICS</th><th>"+finf.getProperty("math")+"</th><th>"+fins.getProperty("math")+"</th><th>"+agg.getProperty("math")
                + "\n</th><th>"+remark.getProperty("math")+"</th><th>"+sign.getProperty("math")+"</th></tr>\n"
                
                + "<tr><th>SCIENCE</th><th>"+finf.getProperty("scie")+"</th><th>"+fins.getProperty("scie")+"</th><th>"+agg.getProperty("scie")
                + "\n</th><th>"+remark.getProperty("scie")+"</th><th>"+sign.getProperty("scie")+"</th></tr>\n"
                
                + "<tr><th>SOCIAL STUDIES</th><th>"+finf.getProperty("sst")+"</th><th>"+fins.getProperty("sst")+"</th><th>"+agg.getProperty("sst")
                + "\n</th><th>"+remark.getProperty("sst")+"</th><th>"+sign.getProperty("sst")+"</th></tr>\n"
                
                /*+ "<tr><th>LITERACY I</th><th>"+finf.getProperty("lt1")+"</th><th>"+fins.getProperty("lt1")+"</th><th>"+agg.getProperty("lt1")
                + "\n</th><th>"+remark.getProperty("lt1")+"</th><th>"+sign.getProperty("lt1")+"</th></tr>\n"
                
                + "<tr><th>LITERACY II</th><th>"+finf.getProperty("lt2")+"</th><th>"+fins.getProperty("lt2")+"</th><th>"+agg.getProperty("lt2")
                + "\n</th><th>"+remark.getProperty("lt2")+"</th><th>"+sign.getProperty("lt2")+"</th></tr>\n"*/
                
                + "<tr><th>RELIGIOUS EDUCATION</th><th>"+finf.getProperty("re")+"</th><th>"+fins.getProperty("re")+"</th><th>"+agg.getProperty("re")
                + "\n</th><th>"+remark.getProperty("re")+"</th><th>"+sign.getProperty("re")+"</th></tr>\n"
                
                /*+ "<tr><th>READING</th><th>"+finf.getProperty("red")+"</th><th>"+fins.getProperty("red")+"</th><th>"+agg.getProperty("red")
                + "\n</th><th>"+remark.getProperty("red")+"</th><th>"+sign.getProperty("red")+"</th></tr>\n"
                
                + "<tr><th>LOCAL LANGUAGE</th><th>"+finf.getProperty("loc")+"</th><th>"+fins.getProperty("loc")+"</th><th>"+agg.getProperty("loc")
                + "\n</th><th>"+remark.getProperty("loc")+"</th><th>"+sign.getProperty("loc")+"</th></tr>\n"
                
                + "<tr><th>ART & CRAFT</th><th>"+finf.getProperty("art")+"</th><th>"+fins.getProperty("art")+"</th><th>"+agg.getProperty("art")
                + "\n</th><th>"+remark.getProperty("art")+"</th><th>"+sign.getProperty("art")+"</th> </tr>\n"*/
                
                + "<tr><th>TOTAL</th><th>"+finf.getProperty("total")+"</th><th>"+fins.getProperty("total")+"</th><th>"+agg.getProperty("total")
                + "\n</th><th> </th><th> </th> </tr></table></th></tr>\n"
                
                + "<tr><th><p/><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>Conduct.............................................."
                + ".................Health...................................Attendance..................................</b></font></th></tr>\n"
                
                +"<tr><th><p/><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>Class Teacher's Report\n"
                + "........................................................................"
                + "....................................................................<br/>\n"
                + "...................................................................................."
                + "..........................................Signature......................................</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+1\" color=\"purple\"><b>SCHOOL REQUIREMENTS</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b> A) Meals: <u>"+details.getProperty("meal")+"</u>\n"
                + " B) Exercise books: <u>"+details.getProperty("book")+"</u></b></font>\n"
                
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\"><b> C) Pens: <u>"+details.getProperty("pen")+"</u>\n"
                + "<br/> D) Operation Fund: <u>"+details.getProperty("fund")+"</u></b></font>\n"
                
                + "<font face=\"Cambria\" size=\"+0\" color=\"black\"><b> E) M.T.C Set:<u>"+details.getProperty("set")+"</u>\n"
                + "</b></font> </th></tr>"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"navy\"><b>NEXT TERM BEGINS ON___"+details.getProperty("nexts")+"___ and \n"
                + "Ends on___"+details.getProperty("nexte")+"</b></font></th></tr>\n"
                
                + "<tr><th><font face=\"Cambria\" size=\"+0\" color=\"black\"><b>HEADTEACHER'S COMMENT\n"
                + "....................................................................................................<BR/>\n"
                + "................................................................................................"
                + "SIGNATURE............................................"
                + "</b></font></th></tr>\n"
                
                + "<tr><th></th></tr> <tr><th><i>\"Invalid without a school stamp\"</i>\n"
                + "<i><b>______________________Powered by Seumx Plus</b></i>\n"
                + "</th></tr>\n";
                
        
        
        //completing report
        report=report+"</table></table></font></body></html>"; cont=report;
        
        //write report to temp file
        File f=new File("temp.html");
        FileWriter wrt=new FileWriter(f);
        wrt.write(report); wrt.flush(); wrt.close();
        
        web.getEngine().load(f.toURI().toURL().toString());
        
    }
    
    public void put(Properties pr, String key, String val) {
        if(val==null) {
            pr.put(key, " ");
        } else {
            pr.put(key, val);
        }
    }
    
}
