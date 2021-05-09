
package report.generator;

import javafx.application.Application;
//import javafx.event.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*; import javafx.scene.image.*;
import javafx.scene.web.*;

import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.PrinterJob;

/**
 * @author Seumx Plus
 */

public class ReportGenerator extends Application {
   
    private Stage stio;
    
    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void start(Stage Stage) throws Exception {
        
        //create cluster folder
        File clt=new File("Cluster");
        
        if(!clt.exists()) {
            clt.mkdirs();
        }
        
        /*
        Initialise
        */
        Handle hd=new Handle();
        
        Image im=new Image(new FileInputStream("Report.png"));
        Stage.getIcons().add(im);
        
        Stage.setWidth(931); Stage.setHeight(627); Stage.initStyle(StageStyle.DECORATED); Stage.setTitle("Report Generator");
        
        Label g=new Label("REPORT GENERATOR");
        g.setStyle("-fx-font:bold 47px 'COPPERPLATE GOTHIC BOLD'; -fx-text-fill:whitesmoke;");
        
        Label exi=new Label("");
        exi.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:whitesmoke;");
        
        Label y=new Label("Generate digital reports.");
        y.setStyle("-fx-font:normal 27px 'Tahoma'; -fx-text-fill:white;");
        
        Button ls=new Button("SignIn NOW"); ls.setPrefWidth(587); ls.setPrefHeight(70);
        ls.setStyle("-fx-font:bold 37px 'Century GOTHIC'; -fx-text-fill:black; -fx-background-color:deepskyblue");
        
        PasswordField ps=new PasswordField(); ps.setPrefWidth(417); 
        ps.setStyle("-fx-font:normal 16px 'Cambria'; -fx-text-fill:white; -fx-control-inner-background:darkslateblue;"
                + "-fx-focus-color:white;");
        
        ls.setOnMouseMoved(ev->{
            ls.setStyle("-fx-font:bold 37px 'Century GOTHIC'; -fx-text-fill:black; -fx-background-color:lightsteelblue");
        });
        ls.setOnMouseExited(ev->{
            ls.setStyle("-fx-font:bold 37px 'Century GOTHIC'; -fx-text-fill:black; -fx-background-color:deepskyblue");
        });
        
        ImageView v=new ImageView(im); v.setFitHeight(273); v.setFitWidth(273);
        
        Label yp=new Label("© Seumx Plus 2021. All Rights Reserved.");
        yp.setStyle("-fx-text-fill:white; -fx-font:normal 17px 'Cambria'");
        HBox yu=new HBox(); yu.setPadding(new Insets(3)); yu.setStyle("-fx-background-color:darkslateblue");
        yu.setAlignment(Pos.CENTER); yu.getChildren().addAll(yp);
        
        GridPane gp=new GridPane(); gp.setPadding(new Insets(13,13,13,13)); gp.setVgap(13); gp.setHgap(13); 
        gp.setAlignment(Pos.CENTER); gp.setStyle("-fx-background-color: darkslateblue"); 
        gp.add(g,0,0); gp.add(y,0,1); gp.add(ps,0,2); gp.add(ls,0,3); gp.add(exi,0,4);
        
        BorderPane brd=new BorderPane(); brd.setPadding(new Insets(0,0,0,0)); brd.setStyle("-fx-background-color: darkslateblue"); 
        brd.setCenter(gp); brd.setBottom(yu);
        
        Stage.setScene(new Scene(brd)); Stage.show();
        
        //nodes
        Button qk=new Button("Report Form"); qk.setPrefWidth(778);
        qk.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
        
        Button sc=new Button("Clusters"); sc.setPrefWidth(778);
        sc.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
        
        Button st=new Button("App Info"); st.setPrefWidth(778);
        st.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
        
        GridPane up=new GridPane(); up.setPadding(new Insets(3,3,3,3)); up.setVgap(3); up.setHgap(3); 
        up.setAlignment(Pos.TOP_CENTER); up.setStyle("-fx-background-color:darkslateblue"); 
        up.add(qk,0,0); up.add(sc,1,0); up.add(st,2,0);
        
        
        //creating the report form
            TextField scf=new TextField(); scf.setPromptText("School Name"); scf.setPrefWidth(317);
            scf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField boxf=new TextField(); boxf.setPromptText("P.O Box Number"); boxf.setPrefWidth(317);
            boxf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField mtf=new TextField(); mtf.setPromptText("School Motto"); mtf.setPrefWidth(317);
            mtf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField tamf=new TextField(); tamf.setPromptText("Term"); tamf.setPrefWidth(317);
            tamf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField pnam=new TextField(); pnam.setPromptText("Pupil's Name"); pnam.setPrefWidth(317);
            pnam.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField clas=new TextField(); clas.setPromptText("Class"); clas.setPrefWidth(317);
            clas.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField pos=new TextField(); pos.setPromptText("Position"); pos.setPrefWidth(317);
            pos.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField out=new TextField(); out.setPromptText("Out Of"); out.setPrefWidth(317);
            out.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            Button midrep=new Button("Enter Mid-Term Score"); midrep.setPrefWidth(317);
            midrep.setStyle("-fx-background-color:darkslateblue; -fx-font:bold 16px 'Cambria'; -fx-text-fill:white;");
            
            Button fnrep=new Button("Enter Termly Score"); fnrep.setPrefWidth(317);
            fnrep.setStyle("-fx-background-color:darkslateblue; -fx-font:bold 16px 'Cambria'; -fx-text-fill:white;");
            
            Button tref=new Button("Teachers' Creditials"); tref.setPrefWidth(317);
            tref.setStyle("-fx-background-color:darkslateblue; -fx-font:bold 16px 'Cambria'; -fx-text-fill:white;");
            
            Label scre=new Label("SCHOOL REQUIREMENTS");
            scre.setStyle("-fx-font:bold 19px 'Cambria'");
            
            TextField meal=new TextField(); meal.setPromptText("Meals"); meal.setPrefWidth(317);
            meal.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField book=new TextField(); book.setPromptText("Exercise Books"); book.setPrefWidth(317);
            book.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField pen=new TextField(); pen.setPromptText("Pens"); pen.setPrefWidth(317);
            pen.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField fund=new TextField(); fund.setPromptText("Operation Fund"); fund.setPrefWidth(317);
            fund.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField set=new TextField(); set.setPromptText("Mathematical Set"); set.setPrefWidth(317);
            set.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField nxts=new TextField(); nxts.setPromptText("Next term begins ON"); nxts.setPrefWidth(317);
            nxts.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField nxte=new TextField(); nxte.setPromptText("Next Term Ends ON"); nxte.setPrefWidth(317);
            nxte.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            Button clear=new Button("Clear Current Values"); clear.setPrefWidth(317); clear.setPrefHeight(40);
            clear.setStyle("-fx-background-color:darkred; -fx-font:bold 16px 'Cambria'; -fx-text-fill:white;"); 
            
            Button gen=new Button("GENERATE REPORT"); gen.setPrefWidth(317); gen.setPrefHeight(40);
            gen.setStyle("-fx-background-color:darkgreen; -fx-font:bold 16px 'Cambria'; -fx-text-fill:white;"); 
            
            ComboBox combo=new ComboBox(FXCollections.observableArrayList("Lower","Upper"));
            combo.setStyle("-fx-control-inner-background:white; -fx-accent:green; -fx-font:normal 17px 'Cambria';");
            
            //we start the algorithm here
            //mid term properties
            Properties midful=new Properties(); Properties midscore=new Properties();
            //termly properties
            Properties terful=new Properties(); Properties terscore=new Properties();
            Properties teragg=new Properties(); Properties terremark=new Properties();
            //data property
            Properties data=new Properties();
            //teachercreditials
            Properties trp=new Properties();
        
        //node action
        ls.setOnAction(ev->{
            
            String status="cabolt";
            
            if(ps.getText().length() == 18) {
                    
                    String me=ps.getText();  me=me.replaceAll("SMX", ""); me=me.replaceAll("-", "");
                    
                    System.out.println(me);
                    
                    char[] eq=me.toCharArray(); List<Integer> la=new ArrayList(); String add=""; String state="trial";
                    
                    for(int i=0; i<eq.length; i++) {
                        if(add.length()<2) {
                            add=add+eq[i];
                        }
                        if(add.length()==2) {
                            la.add(Integer.valueOf(add)); add="";
                        }
                    }
					
					
                    
                    //start chase
                    Calendar clx=new GregorianCalendar(); int mm=clx.get(Calendar.MONTH) + 1;
                    
                    if(la.get(1)==mm+la.get(0)) { System.out.println("month passed.");
                        
                        if(la.get(2)==clx.get(Calendar.DAY_OF_MONTH)+la.get(0)) {
                            
                            System.out.println("date passed.");
                            
                            if(la.get(3)==clx.get(Calendar.DAY_OF_WEEK)+la.get(0)) {
                                
                                System.out.println("day passed.");
                                
                                if(la.get(4)==clx.get(Calendar.HOUR_OF_DAY)+la.get(0)) {
                                    
                                    System.out.println("hour passed.");
                                    
                                    if(la.get(5)==clx.get(Calendar.MINUTE)+la.get(0) || la.get(5)==clx.get(Calendar.MINUTE)+la.get(0)+1) {
                                        
                                        System.out.println("Activated.");
                                        
                                        status="divinelove-meakness";
                                        
                                    }
                                    
                                }
                                
                            }
                        
                        }
                        
                    }
            } 
            
            if(status.equals("divinelove-meakness")) {
            gp.getChildren().clear(); gp.add(v,0,0);
            brd.setTop(up); gp.setStyle("-fx-background-color:white");} else {
                exi.setText("Wrong Values Submitted.");
            }
        });
        
        ps.setOnAction(ev->{
            String status="cabolt";
            
            if(ps.getText().length() == 18) {
                    
                    String me=ps.getText();  me=me.replaceAll("SMX", ""); me=me.replaceAll("-", "");
                    
                    System.out.println(me);
                    
                    char[] eq=me.toCharArray(); List<Integer> la=new ArrayList(); String add=""; String state="trial";
                    
                    for(int i=0; i<eq.length; i++) {
                        if(add.length()<2) {
                            add=add+eq[i];
                        }
                        if(add.length()==2) {
                            la.add(Integer.valueOf(add)); add="";
                        }
                    }
					
					
                    
                    //start chase
                    Calendar clx=new GregorianCalendar(); int mm=clx.get(Calendar.MONTH) + 1;
                    
                    if(la.get(1)==mm+la.get(0)) { System.out.println("month passed.");
                        
                        if(la.get(2)==clx.get(Calendar.DAY_OF_MONTH)+la.get(0)) {
                            
                            System.out.println("date passed.");
                            
                            if(la.get(3)==clx.get(Calendar.DAY_OF_WEEK)+la.get(0)) {
                                
                                System.out.println("day passed.");
                                
                                if(la.get(4)==clx.get(Calendar.HOUR_OF_DAY)+la.get(0)) {
                                    
                                    System.out.println("hour passed.");
                                    
                                    if(la.get(5)==clx.get(Calendar.MINUTE)+la.get(0) || la.get(5)==clx.get(Calendar.MINUTE)+la.get(0)+1) {
                                        
                                        System.out.println("Activated.");
                                        
                                        status="divinelove-meakness";
                                        
                                    }
                                    
                                }
                                
                            }
                        
                        }
                        
                    }
            } 
            
            if(status.equals("divinelove-meakness")) {
            gp.getChildren().clear(); gp.add(v,0,0);
            brd.setTop(up); gp.setStyle("-fx-background-color:white");} else {
                exi.setText("Wrong Values Submitted.");
            }
        });
        
        qk.setOnAction(ev->{ gp.getChildren().clear(); gp.setAlignment(Pos.TOP_CENTER);
            qk.setStyle("-fx-background-color:white; -fx-text-fill:black; -fx-font:normal 19px 'Cambria'");
            sc.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            st.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            
            gp.add(scf,0,0); gp.add(boxf,1,0);
            gp.add(mtf,0,1); gp.add(tamf,1,1);
            
            gp.add(pnam,0,2); gp.add(clas,1,2);
            gp.add(pos,0,3); gp.add(out,1,3);
            
            gp.add(midrep,0,4); gp.add(fnrep,1,4);
            gp.add(scre,0,6);
            
            gp.add(meal,0,7); gp.add(book,1,7);
            gp.add(pen,0,8); gp.add(fund,1,8);
            
            gp.add(set,0,9); gp.add(tref,1,9);
            
            gp.add(nxts,0,10); gp.add(nxte,1,10);
            gp.add(clear,0,11); gp.add(gen,1,11); gp.add(combo,2,11);
            
        });
        
        //Enter scores button actios
        midrep.setOnAction(ev->{
            
            //arranging the nodes
            //fullmark collection
            TextField engf=new TextField(midful.getProperty("eng")); engf.setPrefWidth(217); engf.setPromptText("English FullMark");
            engf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField mathf=new TextField(midful.getProperty("math")); mathf.setPrefWidth(217); mathf.setPromptText("Mathematics FullMark");
            mathf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField scief=new TextField(midful.getProperty("scie")); scief.setPrefWidth(217); scief.setPromptText("Science FullMark");
            scief.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField sstf=new TextField(midful.getProperty("sst")); sstf.setPrefWidth(217); sstf.setPromptText("Social Studies FullMark");
            sstf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1f=new TextField(midful.getProperty("lt1")); lt1f.setPrefWidth(217); lt1f.setPromptText("Literacy I FullMark");
            lt1f.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2f=new TextField(midful.getProperty("lt2")); lt2f.setPrefWidth(217); lt2f.setPromptText("Literacy II FullMark");
            lt2f.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ref=new TextField(midful.getProperty("re")); ref.setPrefWidth(217); ref.setPromptText("Religious Education FullMark");
            ref.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField redf=new TextField(midful.getProperty("red")); redf.setPrefWidth(217); redf.setPromptText("Reading FullMark");
            redf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField locf=new TextField(midful.getProperty("loc")); locf.setPrefWidth(217); locf.setPromptText("Local Language FullMark");
            locf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField artf=new TextField(midful.getProperty("art")); artf.setPrefWidth(217); artf.setPromptText("Art & Craft FullMark");
            artf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            //scored marks collection
            TextField engs=new TextField(midscore.getProperty("eng")); engs.setPrefWidth(217); engs.setPromptText("English Score");
            engs.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField maths=new TextField(midscore.getProperty("math")); maths.setPrefWidth(217); maths.setPromptText("Mathematics Score");
            maths.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField scies=new TextField(midscore.getProperty("scie")); scies.setPrefWidth(217); scies.setPromptText("Science Score");
            scies.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ssts=new TextField(midscore.getProperty("sst")); ssts.setPrefWidth(217); ssts.setPromptText("Social Studies Score");
            ssts.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1s=new TextField(midscore.getProperty("lt1")); lt1s.setPrefWidth(217); lt1s.setPromptText("Literacy I Score");
            lt1s.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2s=new TextField(midscore.getProperty("lt2")); lt2s.setPrefWidth(217); lt2s.setPromptText("Literacy II Score");
            lt2s.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField res=new TextField(midscore.getProperty("re")); res.setPrefWidth(217); res.setPromptText("Religious Education Score");
            res.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField reds=new TextField(midscore.getProperty("red")); reds.setPrefWidth(217); reds.setPromptText("Reading Score");
            reds.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField locs=new TextField(midscore.getProperty("loc")); locs.setPrefWidth(217); locs.setPromptText("Local Language Score");
            locs.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField arts=new TextField(midscore.getProperty("art")); arts.setPrefWidth(217); arts.setPromptText("Art & Craft Score");
            arts.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lu=new TextField(midscore.getProperty("pos")); lu.setPrefWidth(73); lu.setPromptText("Position");
            lu.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField agg=new TextField(midscore.getProperty("agg")); agg.setPrefWidth(73); agg.setPromptText("Aggregates");
            agg.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            Button cmt=new Button("Commit"); cmt.setPrefWidth(217); cmt.setPrefHeight(40);
            cmt.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:navy");
            
            Button cac=new Button("Cancel"); cac.setPrefWidth(217); cac.setPrefHeight(40);
            cac.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:darkred");
            
            //create grid pane
            GridPane mid=new GridPane(); mid.setPadding(new Insets(13,13,13,13)); mid.setVgap(13); mid.setHgap(13);
            mid.setAlignment(Pos.CENTER); mid.setStyle("-fx-background-color:white");
            
            mid.add(engf,0,0); mid.add(engs,1,0); mid.add(lu,2,0); 
            mid.add(mathf,0,1); mid.add(maths,1,1); mid.add(agg,2,1);
            mid.add(scief,0,2); mid.add(scies,1,2);
            mid.add(sstf,0,3); mid.add(ssts,1,3);
            mid.add(lt1f,0,4); mid.add(lt1s,1,4);
            mid.add(lt2f,0,5); mid.add(lt2s,1,5);
            mid.add(ref,0,6); mid.add(res,1,6);
            mid.add(redf,0,7); mid.add(reds,1,7);
            mid.add(locf,0,8); mid.add(locs,1,8);
            mid.add(artf,0,9); mid.add(arts,1,9);
            
            mid.add(cac,0,10); mid.add(cmt,1,10); //System.out.println("here...");
            
            //creating the window 
            if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setTitle("Enter Mid-Term Values"); stio.getIcons().add(im); stio.setScene(new Scene(mid));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setTitle("Enter Mid-Term Values"); stio.getIcons().add(im); stio.setScene(new Scene(mid));
                stio.initOwner(Stage); stio.show();
            }
            
            //givingg actions
            cac.setOnAction(evi->{
                stio.close();
            });
            
            cmt.setOnAction(evi->{
                
                //save mid full
                hd.put(midful,"eng",engf.getText()); hd.put(midful,"math",mathf.getText());
                hd.put(midful,"scie",scief.getText()); hd.put(midful,"sst",sstf.getText());
                hd.put(midful, "lt1",lt1f.getText()); hd.put(midful,"lt2",lt2f.getText());
                
                hd.put(midful,"re",ref.getText()); hd.put(midful,"red",redf.getText());
                hd.put(midful,"loc",locf.getText()); hd.put(midful,"art",artf.getText());
                
                //save mid score
                hd.put(midscore,"eng",engs.getText()); hd.put(midscore,"math",maths.getText());
                hd.put(midscore,"scie",scies.getText()); hd.put(midscore,"sst",ssts.getText());
                hd.put(midscore,"lt1",lt1s.getText()); hd.put(midscore,"lt2",lt2s.getText());
                hd.put(midscore,"re",res.getText()); hd.put(midscore,"red",reds.getText());
                hd.put(midscore,"loc",locs.getText()); hd.put(midscore,"art",arts.getText()); 
                
                hd.put(midscore,"pos", lu.getText()); hd.put(midscore,"agg", agg.getText());
                
                stio.close();
                
            });
            
        });
        
        fnrep.setOnAction(ev->{
            
           //arranging the nodes
            //fullmark collection
            TextField engf=new TextField(terful.getProperty("eng")); engf.setPrefWidth(217); engf.setPromptText("English FullMark");
            engf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField mathf=new TextField(terful.getProperty("math")); mathf.setPrefWidth(217); mathf.setPromptText("Mathematics FullMark");
            mathf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField scief=new TextField(terful.getProperty("scie")); scief.setPrefWidth(217); scief.setPromptText("Science FullMark");
            scief.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField sstf=new TextField(terful.getProperty("sst")); sstf.setPrefWidth(217); sstf.setPromptText("Social Studies FullMark");
            sstf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1f=new TextField(terful.getProperty("lt1")); lt1f.setPrefWidth(217); lt1f.setPromptText("Literacy I FullMark");
            lt1f.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2f=new TextField(terful.getProperty("lt2")); lt2f.setPrefWidth(217); lt2f.setPromptText("Literacy II FullMark");
            lt2f.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ref=new TextField(terful.getProperty("re")); ref.setPrefWidth(217); ref.setPromptText("Religious Education FullMark");
            ref.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField redf=new TextField(terful.getProperty("red")); redf.setPrefWidth(217); redf.setPromptText("Reading FullMark");
            redf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField locf=new TextField(terful.getProperty("loc")); locf.setPrefWidth(217); locf.setPromptText("Local Language FullMark");
            locf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField artf=new TextField(terful.getProperty("art")); artf.setPrefWidth(217); artf.setPromptText("Art & Craft FullMark");
            artf.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            //scored marks collection
            TextField engs=new TextField(terscore.getProperty("eng")); engs.setPrefWidth(217); engs.setPromptText("English Score");
            engs.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField maths=new TextField(terscore.getProperty("math")); maths.setPrefWidth(217); maths.setPromptText("Mathematics Score");
            maths.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField scies=new TextField(terscore.getProperty("scie")); scies.setPrefWidth(217); scies.setPromptText("Science Score");
            scies.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ssts=new TextField(terscore.getProperty("sst")); ssts.setPrefWidth(217); ssts.setPromptText("Social Studies Score");
            ssts.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1s=new TextField(terscore.getProperty("lt1")); lt1s.setPrefWidth(217); lt1s.setPromptText("Literacy I Score");
            lt1s.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2s=new TextField(terscore.getProperty("lt2")); lt2s.setPrefWidth(217); lt2s.setPromptText("Literacy II Score");
            lt2s.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField res=new TextField(terscore.getProperty("re")); res.setPrefWidth(217); res.setPromptText("Religious Education Score");
            res.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField reds=new TextField(terscore.getProperty("red")); reds.setPrefWidth(217); reds.setPromptText("Reading Score");
            reds.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField locs=new TextField(terscore.getProperty("loc")); locs.setPrefWidth(217); locs.setPromptText("Local Language Score");
            locs.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField arts=new TextField(terscore.getProperty("art")); arts.setPrefWidth(217); arts.setPromptText("Art & Craft Score");
            arts.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            //aggregates
            TextField enga=new TextField(teragg.getProperty("eng")); enga.setPrefWidth(217); enga.setPromptText("English Agg.");
            enga.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField matha=new TextField(teragg.getProperty("math")); matha.setPrefWidth(217); matha.setPromptText("Mathematics Agg.");
            matha.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField sciea=new TextField(teragg.getProperty("scie")); sciea.setPrefWidth(217); sciea.setPromptText("Science Agg.");
            sciea.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ssta=new TextField(teragg.getProperty("sst")); ssta.setPrefWidth(217); ssta.setPromptText("Social Studies Agg.");
            ssta.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1a=new TextField(teragg.getProperty("lt1")); lt1a.setPrefWidth(217); lt1a.setPromptText("Literacy I Agg.");
            lt1a.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2a=new TextField(teragg.getProperty("lt2")); lt2a.setPrefWidth(217); lt2a.setPromptText("Literacy II Agg.");
            lt2a.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField rea=new TextField(teragg.getProperty("re")); rea.setPrefWidth(217); rea.setPromptText("Religious Education Agg.");
            rea.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField reda=new TextField(teragg.getProperty("red")); reda.setPrefWidth(217); reda.setPromptText("Reading Agg.");
            reda.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField loca=new TextField(teragg.getProperty("loc")); loca.setPrefWidth(217); loca.setPromptText("Local Language Agg.");
            loca.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField arta=new TextField(teragg.getProperty("art")); arta.setPrefWidth(217); arta.setPromptText("Art & Craft Agg.");
            arta.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField ttag=new TextField(teragg.getProperty("total")); ttag.setPrefWidth(217); ttag.setPromptText("Total Agg");
            ttag.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            //Remarks
            TextField engr=new TextField(terremark.getProperty("eng")); engr.setPrefWidth(217); engr.setPromptText("English Remarks");
            engr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField mathr=new TextField(terremark.getProperty("math")); mathr.setPrefWidth(217); mathr.setPromptText("Mathematics Remarks");
            mathr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField scier=new TextField(terremark.getProperty("scie")); scier.setPrefWidth(217); scier.setPromptText("Science Remarks");
            scier.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField sstr=new TextField(terremark.getProperty("sst")); sstr.setPrefWidth(217); sstr.setPromptText("Social Studies Remarks");
            sstr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt1r=new TextField(terremark.getProperty("lt1")); lt1r.setPrefWidth(217); lt1r.setPromptText("Literacy I Remarks");
            lt1r.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField lt2r=new TextField(terremark.getProperty("lt2")); lt2r.setPrefWidth(217); lt2r.setPromptText("Literacy II Remarks");
            lt2r.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField rer=new TextField(terremark.getProperty("re")); rer.setPrefWidth(217); rer.setPromptText("Religious Education Remarks");
            rer.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField redr=new TextField(terremark.getProperty("red")); redr.setPrefWidth(217); redr.setPromptText("Reading Remarks");
            redr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField locr=new TextField(terremark.getProperty("loc")); locr.setPrefWidth(217); locr.setPromptText("Local Language Remarks");
            locr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            TextField artr=new TextField(terremark.getProperty("art")); artr.setPrefWidth(217); artr.setPromptText("Art & Craft Remarks");
            artr.setStyle("-fx-font: normal 17px 'Cambria'; -fx-control-inner-background:lightgrey;");
            
            //action buttons
            Button cmt=new Button("Commit"); cmt.setPrefWidth(217); cmt.setPrefHeight(40);
            cmt.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:navy");
            
            Button cac=new Button("Cancel"); cac.setPrefWidth(217); cac.setPrefHeight(40);
            cac.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:darkred");
            
            //create grid pane
            GridPane mid=new GridPane(); mid.setPadding(new Insets(13,13,13,13)); mid.setVgap(13); mid.setHgap(13);
            mid.setAlignment(Pos.CENTER); mid.setStyle("-fx-background-color:white");
            
            mid.add(engf,0,0); mid.add(engs,1,0); mid.add(enga,2,0); mid.add(engr,3,0);
            mid.add(mathf,0,1); mid.add(maths,1,1); mid.add(matha,2,1); mid.add(mathr,3,1);
            mid.add(scief,0,2); mid.add(scies,1,2); mid.add(sciea,2,2); mid.add(scier,3,2);
            mid.add(sstf,0,3); mid.add(ssts,1,3); mid.add(ssta,2,3); mid.add(sstr,3,3);
            mid.add(lt1f,0,4); mid.add(lt1s,1,4); mid.add(lt1a,2,4); mid.add(lt1r,3,4);
            mid.add(lt2f,0,5); mid.add(lt2s,1,5); mid.add(lt2a,2,5); mid.add(lt2r,3,5);
            mid.add(ref,0,6); mid.add(res,1,6); mid.add(rea,2,6); mid.add(rer,3,6);
            mid.add(redf,0,7); mid.add(reds,1,7); mid.add(reda,2,7); mid.add(redr,3,7);
            mid.add(locf,0,8); mid.add(locs,1,8); mid.add(loca,2,8); mid.add(locr,3,8);
            mid.add(artf,0,9); mid.add(arts,1,9); mid.add(arta,2,9); mid.add(artr,3,9);
            mid.add(ttag,2,10);
            
            mid.add(cac,2,11); mid.add(cmt,3,11); //System.out.println("here...");
            
            //creating the window 
            if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setTitle("Enter Termly Values"); stio.getIcons().add(im); stio.setScene(new Scene(mid));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setTitle("Enter Termly Values"); stio.getIcons().add(im); stio.setScene(new Scene(mid));
                stio.initOwner(Stage); stio.show();
            }
            
            //givingg actions
            cac.setOnAction(evi->{
                stio.close();
            });
            
            cmt.setOnAction(evi->{
                
                //save mid full
                hd.put(terful,"eng",engf.getText()); hd.put(terful,"math",mathf.getText());
                hd.put(terful,"scie",scief.getText()); hd.put(terful,"sst",sstf.getText()); 
                hd.put(terful,"lt1",lt1f.getText()); hd.put(terful,"lt2",lt2f.getText());
                hd.put(terful,"re",ref.getText()); hd.put(terful,"red",redf.getText());
                hd.put(terful,"loc",locf.getText()); hd.put(terful,"art",artf.getText());
                
                //save mid score
                hd.put(terscore,"eng",engs.getText()); hd.put(terscore,"math",maths.getText());
                hd.put(terscore,"scie",scies.getText()); hd.put(terscore,"sst",ssts.getText());
                hd.put(terscore,"lt1",lt1s.getText()); hd.put(terscore,"lt2",lt2s.getText());
                hd.put(terscore,"re",res.getText()); hd.put(terscore,"red",reds.getText());
                hd.put(terscore,"loc",locs.getText()); hd.put(terscore,"art",arts.getText());
                
                //save aggregates
                hd.put(teragg,"eng",enga.getText()); hd.put(teragg,"math",matha.getText());
                hd.put(teragg,"scie",sciea.getText()); hd.put(teragg,"sst",ssta.getText());
                hd.put(teragg,"lt1",lt1a.getText()); hd.put(teragg,"lt2",lt2a.getText());
                hd.put(teragg,"re",rea.getText()); hd.put(teragg,"red",reda.getText());
                hd.put(teragg,"loc",loca.getText()); hd.put(teragg,"art",arta.getText());
                hd.put(teragg,"total", ttag.getText());
                
                //save remark
                hd.put(terremark,"eng",engr.getText()); hd.put(terremark,"math",mathr.getText());
                hd.put(terremark,"scie",scier.getText()); hd.put(terremark,"sst",sstr.getText());
                hd.put(terremark,"lt1",lt1r.getText()); hd.put(terremark,"lt2",lt2r.getText());
                hd.put(terremark,"re",rer.getText()); hd.put(terremark,"red",redr.getText());
                hd.put(terremark,"loc",locr.getText()); hd.put(terremark,"art",artr.getText());
                
                stio.close();
                
            });
            
        });
        
        clear.setOnAction(ev->{
            
            //erasing data
            scf.setText(null); boxf.setText(null); mtf.setText(null); tamf.setText(null);
            pnam.setText(null); clas.setText(null); pos.setText(null); out.setText(null);
            meal.setText(null); book.setText(null); pen.setText(null); fund.setText(null);
            set.setText(null); nxts.setText(null); nxte.setText(null);
            
            midful.clear(); midscore.clear(); terful.clear(); terscore.clear();
            teragg.clear(); terremark.clear(); data.clear();
            
        });
        
        gen.setOnAction(ev->{
            
            //collect data property
            hd.put(data,"sch", scf.getText()); hd.put(data,"box", boxf.getText());
            hd.put(data,"motto", mtf.getText()); hd.put(data,"term", tamf.getText());
            hd.put(data,"pname", pnam.getText()); hd.put(data,"class", clas.getText());
            hd.put(data,"pos", pos.getText()); hd.put(data,"out", out.getText());
            hd.put(data,"meal", meal.getText()); hd.put(data,"book", book.getText());
            hd.put(data,"pen", pen.getText()); hd.put(data,"fund", fund.getText());
            hd.put(data,"set", set.getText()); hd.put(data,"nexts", nxts.getText());
            hd.put(data,"nexte", nxte.getText());
            
            //generating report by calling function
            WebView web=new WebView();
            try {
                
                if(combo.getValue()=="Lower") {
            hd.generate(data, midful, midscore, terful, terscore, teragg, terremark, trp, web); 
                }
                else {
                    hd.generateU(data, midful, midscore, terful, terscore, teragg, terremark, trp, web);
                }
            hd.showReport(web, Stage, im,pnam.getText());
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        });
        
        
        sc.setOnAction(ev->{ gp.getChildren().clear(); gp.setAlignment(Pos.TOP_CENTER);
            sc.setStyle("-fx-background-color:white; -fx-text-fill:black; -fx-font:normal 19px 'Cambria'");
            qk.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            st.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            
            //create clusetr ppnn
            String[] jk=clt.list(); List<String> por=new ArrayList();
            
            for(int i=0; i<jk.length; i++) {
                por.add(jk[i]);
            }
            
            TextField ur=new TextField(); ur.setPrefWidth(700); ur.setPromptText("Enter Cluster Name Here To Create");
            ur.setStyle("-fx-font:normal 16px 'Cambria'; -fx-text-fill:azure; -fx-control-inner-background:darkslateblue");
            
            Button crt=new Button("Create New Cluster"); crt.setPrefWidth(700); crt.setPrefHeight(40);
            crt.setStyle("-fx-background-color:darkslateblue; -fx-font:normal 17px 'Cambria'; -fx-text-fill:white;");
            
            Button pra=new Button("Print Setected Cluster"); pra.setPrefWidth(341); pra.setPrefHeight(40); pra.setDisable(true);
            pra.setStyle("-fx-background-color:darkslateblue; -fx-font:normal 17px 'Cambria'; -fx-text-fill:white;"); 
            pra.setPadding(new Insets(13));
            
            Button viw=new Button("View Setected Cluster"); viw.setPrefWidth(341); viw.setPrefHeight(40); viw.setDisable(true);
            viw.setStyle("-fx-background-color:darkslateblue; -fx-font:normal 17px 'Cambria'; -fx-text-fill:white;");
            viw.setPadding(new Insets(13));
            
            GridPane hb=new GridPane(); hb.setPadding(new Insets(5,5,5,5)); hb.setHgap(17); hb.setAlignment(Pos.CENTER);
            hb.add(viw,0,0); hb.add(pra,1,0);
            
            ObservableList jui=FXCollections.observableArrayList(por); ListView vyu=new ListView(jui);
            vyu.setPrefWidth(700); vyu.setPrefHeight(517);
            vyu.setStyle("-fx-control-inner-background:darkslateblue; -fx-font:bold 16px 'Cambria'; -fx-accent: white;"
                    + "-fx-focus-color:whitesmoke;-fx-body-color:darkred;");
            
            MenuItem delete=new MenuItem("Delete!");
            ContextMenu cmi=new ContextMenu(delete); cmi.setStyle("-fx-font:normal 17px 'Cambria'; -fx-accent: royalblue;");
            vyu.setContextMenu(cmi);
            
            GridPane ol=new GridPane(); ol.setPadding(new Insets(9,9,9,9)); ol.setVgap(9); ol.setHgap(9);
            ol.setAlignment(Pos.CENTER); ol.setStyle("-fx-background-color:white");
            ol.add(ur,0,0); ol.add(crt,0,1); ol.add(vyu,0,2); ol.add(hb,0,3);
            
            gp.add(ol,0,0);
            
            delete.setOnAction(eu->{
                
                
                
            });
            
            crt.setOnAction(eiv->{ try {
                
                if(!new File(clt+"/"+ur.getText()).exists() && !new File(clt+"/"+ur.getText()+"/data.bat").exists()) {
                
                File fr=new File(clt+"/"+ur.getText());
                fr.mkdir();
                
                Properties fh=new Properties();
                
                FileOutputStream fo=new FileOutputStream(fr+"/data.bat");
                ObjectOutputStream obj=new ObjectOutputStream(fo);
                obj.writeObject(fh); obj.flush(); obj.close(); ur.setText("");
                
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                
            });
            
            vyu.setOnMouseClicked(oui->{
                
                //print all cluster
                if(oui.getClickCount()==1) {
                    
                    pra.setDisable(false); viw.setDisable(false);
                    
                }
                
                if(oui.getClickCount()==2) {
                    
                    try {
                    
                    String u=vyu.getSelectionModel().getSelectedItem().toString(); List<String> lo=new ArrayList();
                    
                    FileInputStream fin=new FileInputStream(clt+"/"+u+"/data.bat");
                    ObjectInputStream la=new ObjectInputStream(fin);
                    Properties ik=(Properties) la.readObject();
                    
                    Set ste=ik.keySet(); Iterator iti=ste.iterator();
                    
                    while(iti.hasNext()) {
                        lo.add(iti.next().toString());
                    }
                    
                    ObservableList<String> obser=FXCollections.observableArrayList(lo);
                    ListView rew=new ListView(obser); rew.setPrefWidth(1003); rew.setPrefHeight(1003);
                    rew.setStyle("-fx-control-inner-background:darkslateblue; -fx-font:bold 16px 'Cambria'; -fx-accent: white;");
                    
                    TextField tfi=new TextField(); 
                    tfi.setStyle("-fx-font:normal 17px 'Cambria'; -fx-control-inner-background:navy");
                    
                    GridPane i =new GridPane(); i.setPadding(new Insets(3,3,3,3)); i.setVgap(3); i.setHgap(3);
                    i.setAlignment(Pos.CENTER); i.setStyle("-fx-background-color:white"); i.add(rew,0,1); i.add(tfi,0,0);
                    
                    tfi.setOnKeyReleased(iue->{
                        
                        List<String> lio=new ArrayList();
                        //create filtering system
                        for(int q=0; q<lo.size(); q++) {
                            if(lo.get(q).contains(tfi.getText())) {
                                lio.add(lo.get(q));
                            }
                        }
                        
                        //set new obser.
                        obser.clear(); obser.addAll(lio); rew.setItems(obser);
                        
                    });
                    
                    
            //add menu item
            ContextMenu cm=new ContextMenu(); 
            cm.setStyle("-fx-font: normal 16px 'Cambria'; -fx-accent: white; -fx-control-inner-background: royalblue;");
            MenuItem prv=new MenuItem("Preview"); MenuItem edi=new MenuItem("Quick Edit"); MenuItem dele=new MenuItem("Delete!");
            cm.getItems().addAll(prv,edi,dele);
            
            //add to vs
            rew.setContextMenu(cm);
            
            dele.setOnAction(er->{
                
                try {
                
                String ye=rew.getSelectionModel().getSelectedItem().toString();
                
                ik.remove(ye);
                
                FileOutputStream ou=new FileOutputStream(clt+"/"+u+"/data.bat");
                ObjectOutputStream obj=new ObjectOutputStream(ou);
                obj.writeObject(ik); obj.flush(); obj.close();
                
                rew.getItems().remove(ye);
                
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            });
            
            prv.setOnAction(eri->{
                String ye=rew.getSelectionModel().getSelectedItem().toString();
                            
                            String rrp=ik.getProperty(ye);
                            
                            WebView vww=new WebView(); vww.setPrefWidth(1133); vww.setPrefHeight(1003);
                            
                            //write file to temp
                            try{
                            FileWriter wrt=new FileWriter(new File("temp.html"));
                            wrt.write(rrp); wrt.flush(); wrt.close();
                            
                            vww.getEngine().load(new File("temp.html").toURI().toURL().toString());
                            
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                            //make scene 
                            Button print=new Button("Print"); print.setPrefWidth(317);
                            print.setStyle("-fx-background-color:navy; -fx-text-fill:white; -fx-font:bold 16px 'Cambria'");
                            
                            GridPane iu=new GridPane(); iu.setPadding(new Insets(3,3,3,3)); iu.setVgap(3);
                            iu.setHgap(3); iu.setAlignment(Pos.CENTER); iu.setStyle("-fx-background-color:white");
                            iu.add(vww,0,0); iu.add(print,0,1);
                            
                            Stage stager=new Stage(); stager.setResizable(false); stager.initStyle(StageStyle.DECORATED);
                stager.setWidth(831); stager.setHeight(538);
                stager.setTitle("View Report"); stager.getIcons().add(im); stager.setScene(new Scene(iu));
                stager.initOwner(stio); stager.show();
                
                            print.setOnAction(evir->{
                                
                                PrinterJob job=PrinterJob.createPrinterJob();
                                
                                if(job!=null && job.showPrintDialog(stager)) {
                                    vww.getEngine().print(job);
                                    job.endJob(); stager.close();
                                }
                            });
            });
            
            edi.setOnAction(eri->{
                String ye=rew.getSelectionModel().getSelectedItem().toString();
                            
                            String rrp=ik.getProperty(ye);
                            
                            HTMLEditor ui=new HTMLEditor(); ui.setHtmlText(rrp); 
                            ui.setPrefWidth(831); ui.setPrefHeight(538);
                            
                            Button save=new Button("Save"); save.setPrefWidth(317);
                            save.setStyle("-fx-background-color:navy; -fx-text-fill:white; -fx-font:bold 16px 'Cambria'");
                            
                            GridPane iu=new GridPane(); iu.setPadding(new Insets(3,3,3,3)); iu.setVgap(3);
                            iu.setHgap(3); iu.setAlignment(Pos.CENTER); iu.setStyle("-fx-background-color:white");
                            iu.add(ui,0,0); iu.add(save,0,1);
                            
                            Stage stager=new Stage(); stager.setResizable(false); stager.initStyle(StageStyle.DECORATED);
                stager.setWidth(831); stager.setHeight(538);
                stager.setTitle("Edit Report"); stager.getIcons().add(im); stager.setScene(new Scene(iu));
                stager.initOwner(stio); stager.show();
                
                save.setOnAction(eyo->{
                    
                    ik.put(ye,ui.getHtmlText().replaceAll("contenteditable=\"true\"", "")
                            .replaceAll("bgcolor:white=\"\"","background=\"bgs/bg2.png\"").replaceAll("dir=\"ltr\"", ""));
                    
                    try {
                    FileOutputStream fou=new FileOutputStream(clt+"/"+u+"/data.bat");
                    ObjectOutputStream ou=new ObjectOutputStream(fou);
                    ou.writeObject(ik); ou.flush(); ou.close();
                    
                    stager.close();
                    
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                });
                
            });
                    
                    rew.setOnMouseClicked(iop->{
                        
                        if(iop.getClickCount()==2) {
                            
                            String ye=rew.getSelectionModel().getSelectedItem().toString();
                            
                            String rrp=ik.getProperty(ye);
                            
                            WebView vww=new WebView(); vww.setPrefWidth(1133); vww.setPrefHeight(1003);
                            
                            //write file to temp
                            try{
                            FileWriter wrt=new FileWriter(new File("temp.html"));
                            wrt.write(rrp); wrt.flush(); wrt.close();
                            
                            vww.getEngine().load(new File("temp.html").toURI().toURL().toString());
                            
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                            //make scene 
                            Button print=new Button("Print"); print.setPrefWidth(317);
                            print.setStyle("-fx-background-color:navy; -fx-text-fill:white; -fx-font:bold 16px 'Cambria'");
                            
                            GridPane iu=new GridPane(); iu.setPadding(new Insets(3,3,3,3)); iu.setVgap(3);
                            iu.setHgap(3); iu.setAlignment(Pos.CENTER); iu.setStyle("-fx-background-color:white");
                            iu.add(vww,0,0); iu.add(print,0,1);
                            
                            Stage stager=new Stage(); stager.setResizable(false); stager.initStyle(StageStyle.DECORATED);
                stager.setWidth(831); stager.setHeight(538);
                stager.setTitle("View Report"); stager.getIcons().add(im); stager.setScene(new Scene(iu));
                stager.initOwner(stio); stager.show();
                
                            print.setOnAction(evir->{
                                
                                PrinterJob job=PrinterJob.createPrinterJob();
                                
                                if(job!=null && job.showPrintDialog(stager)) {
                                    vww.getEngine().print(job);
                                    job.endJob(); stager.close();
                                }
                            });
                        }
                    });
                    
                    
                    if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(571); stio.setHeight(418);
                stio.setTitle("View Cluster Contents"); stio.getIcons().add(im); stio.setScene(new Scene(i));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(531); stio.setHeight(378);
                stio.setTitle("View Cluster Contents"); stio.getIcons().add(im); stio.setScene(new Scene(i));
                stio.initOwner(Stage); stio.show();
            }
                    
                 } catch (IOException | ClassNotFoundException epv) {
                        System.out.println(epv.getMessage());
                        }
                }
                
            });
            
            pra.setOnAction(rir->{
                try {
                //printall
                String uq=vyu.getSelectionModel().getSelectedItem().toString();
                
                FileInputStream fqe=new FileInputStream(clt+"/"+uq+"/data.bat");
                ObjectInputStream obq=new ObjectInputStream(fqe);
                Properties pld=(Properties) obq.readObject();
                
                List<String> iq=new ArrayList();
                
                Set sw=pld.keySet(); Iterator itq=sw.iterator(); 
                
                while(itq.hasNext()) {
                    iq.add(itq.next().toString());
                }
                
                System.out.println(iq); String vo="";
                
                for(int i=0; i<iq.size(); i++) {
                    if(pld.getProperty(iq.get(i))!=null)  {
                        
                        vo=vo+pld.getProperty(iq.get(i))+"<P style=\"page-break-before: always\">\n";
                        
                    }
                }
                
                //printing all selected
                File ftl=new File("temp.html");
                FileWriter rti=new FileWriter(ftl);
                        rti.write(vo); rti.flush(); rti.close();
                        
                        WebView yup=new WebView();
                        
                        yup.getEngine().load(ftl.toURI().toURL().toString());
                        
                        PrinterJob hgf=PrinterJob.createPrinterJob();
                        
                        if(hgf!=null && hgf.showPrintDialog(Stage)) {
                            yup.getEngine().print(hgf); 
                            hgf.endJob();
                        }
                        
                        System.out.println("Print Job Successsfully Completed.");
                        
                
                
                } catch(IOException | ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            
            viw.setOnAction(rir->{
                try {
                //printall
                String uq=vyu.getSelectionModel().getSelectedItem().toString();
                
                FileInputStream fqe=new FileInputStream(clt+"/"+uq+"/data.bat");
                ObjectInputStream obq=new ObjectInputStream(fqe);
                Properties pld=(Properties) obq.readObject();
                
                List<String> iq=new ArrayList();
                
                Set sw=pld.keySet(); Iterator itq=sw.iterator(); 
                
                while(itq.hasNext()) {
                    iq.add(itq.next().toString());
                }
                
                System.out.println(iq); String vo="";
                
                for(int i=0; i<iq.size(); i++) {
                    if(pld.getProperty(iq.get(i))!=null)  {
                        
                        vo=vo+pld.getProperty(iq.get(i))+"<P style=\"page-break-before: always\">\n";
                        
                    }
                }
                
                //printing all selected
                File ftl=new File("temp.html");
                FileWriter rti=new FileWriter(ftl);
                        rti.write(vo); rti.flush(); rti.close();
                        
                        WebView yup=new WebView();
                        
                        yup.getEngine().load(ftl.toURI().toURL().toString());
                        
                        if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("View Cluster"); stio.getIcons().add(im); stio.setScene(new Scene(yup));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("View Cluster"); stio.getIcons().add(im); stio.setScene(new Scene(yup));
                stio.initOwner(Stage); stio.show();
            }
                
                
                } catch(IOException | ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            
        });
        
        st.setOnAction(ev->{ gp.getChildren().clear(); gp.setAlignment(Pos.TOP_CENTER);
            st.setStyle("-fx-background-color:white; -fx-text-fill:black; -fx-font:normal 19px 'Cambria'");
            qk.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            sc.setStyle("-fx-background-color:darkslateblue; -fx-text-fill:white; -fx-font:normal 19px 'Cambria'");
            
            //scene
            String di="Company : Seumx Plus\nDevelopers:\n      *Muwanguzi Silas\n      *Muwereza Isaac\n"
                    + "Release Date: 27 February, 2020\nVersion: 1.0.2\nMail: Silas.seal7@gmail.com\n"
                    + "Phone: +256 704029977 | +256 787029977 | +256 702043057\nWeb: https://silas-seal.github.io/seumxplus.smx/";
            
            Label dtl=new Label(di);
            dtl.setStyle("-fx-font:bold 19px 'Cambria';");
            
            gp.add(v,0,0); gp.add(dtl,0,1);
            
        });
        
        tref.setOnAction(evi->{
            
            TextField engtr=new TextField(trp.getProperty("eng")); engtr.setPrefWidth(173); engtr.setPromptText("English Teacher");
            engtr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField mathtr=new TextField(trp.getProperty("math")); mathtr.setPrefWidth(173); mathtr.setPromptText("Mathematics Teacher");
            mathtr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField scietr=new TextField(trp.getProperty("scie")); scietr.setPrefWidth(173); scietr.setPromptText("Science Teacher");
            scietr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField ssttr=new TextField(trp.getProperty("sst")); ssttr.setPrefWidth(173); ssttr.setPromptText("Social Studies Teacher");
            ssttr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField lt1tr=new TextField(trp.getProperty("lt1")); lt1tr.setPrefWidth(173); lt1tr.setPromptText("Literacy I Teacher");
            lt1tr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField lt2tr=new TextField(trp.getProperty("lt2")); lt2tr.setPrefWidth(173); lt2tr.setPromptText("Literacy II Teacher");
            lt2tr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField retr=new TextField(trp.getProperty("re")); retr.setPrefWidth(173); retr.setPromptText("Religious Education Teacher");
            retr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField redtr=new TextField(trp.getProperty("red")); redtr.setPrefWidth(173); redtr.setPromptText("Reading Teacher");
            redtr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField loctr=new TextField(trp.getProperty("loc")); loctr.setPrefWidth(173); loctr.setPromptText("Local language Teacher");
            loctr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            TextField arttr=new TextField(trp.getProperty("art")); arttr.setPrefWidth(173); arttr.setPromptText("Art & Craft Teacher");
            arttr.setStyle("-fx-font:bold 16px 'Cambria'; -fx-control-inner-background:lightgrey");
            
            Button cmt1=new Button("Commit"); cmt1.setPrefWidth(173); cmt1.setPrefHeight(40);
            cmt1.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:navy");
            
            Button cls1=new Button("Cancel"); cls1.setPrefWidth(173); cls1.setPrefHeight(40);
            cls1.setStyle("-fx-font:bold 16px 'Cambria'; -fx-text-fill:white; -fx-background-color:darkred");
            
            GridPane pl=new GridPane(); pl.setVgap(7); pl.setHgap(7); pl.setPadding(new Insets(7,7,7,7));
            pl.setAlignment(Pos.CENTER); pl.setStyle("-fx-background-color:white");
            
            pl.add(engtr,0,0); pl.add(mathtr,1,0);
            pl.add(scietr,0,1); pl.add(ssttr,1,1);
            pl.add(lt1tr,0,2); pl.add(lt2tr,1,2);
            pl.add(retr,0,3); pl.add(redtr,1,3);
            pl.add(loctr,0,4); pl.add(arttr,1,4);
            pl.add(cls1,0,5); pl.add(cmt1,1,5);
            
            //make up the scene
            if(stio!=null) {
                stio.close();
                
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                //stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Teacher Credintials"); stio.getIcons().add(im); stio.setScene(new Scene(pl));
                stio.initOwner(Stage); stio.show();
                
            } else {
                stio=new Stage(); stio.setResizable(false); stio.initStyle(StageStyle.DECORATED);
                //stio.setWidth(831); stio.setHeight(578);
                stio.setTitle("Teacher Credintials"); stio.getIcons().add(im); stio.setScene(new Scene(pl));
                stio.initOwner(Stage); stio.show();
            }
            
            cls1.setOnAction(ev->{
                stio.close();
            });
            
            cmt1.setOnAction(ev->{
                
                //properrty putting 
                hd.put(trp,"eng",engtr.getText()); hd.put(trp,"math",mathtr.getText());
                hd.put(trp,"scie",scietr.getText()); hd.put(trp,"sst",ssttr.getText()); 
                hd.put(trp,"lt1",lt1tr.getText()); hd.put(trp,"lt2",lt2tr.getText()); 
                hd.put(trp,"re",retr.getText()); hd.put(trp,"red",redtr.getText()); 
                hd.put(trp,"loc",loctr.getText()); hd.put(trp,"art",arttr.getText()); 
                
                stio.close();
                
            });
            
        });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}