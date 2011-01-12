/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gupa.midlet;

import java.util.Hashtable;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.gupa.j2me.GUPAConsumer;
import net.oauth.j2me.OAuthServiceProviderException;
import net.oauth.j2me.token.AccessToken;
import net.oauth.j2me.token.RequestToken;
import org.json.me.JSONArray;
import org.json.me.JSONObject;

/**
 * @author mtrcn
 */
public class GUPAMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private GUPAConsumer consumer;
    private RequestToken requestToken = null;
    private AccessToken accessToken = null;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command backCommand;
    private Command authorizeCommand;
    private Command getAccessTokenCommand;
    private Command okCommand;
    private List main_menu_list;
    private Form yetkilendir_form;
    private StringItem stringItem;
    private Form yetki_kodu_form;
    private TextField textField;
    private Form temel_odev_1_form;
    private TextField coord_azimuth;
    private TextField coord_point;
    private TextField coord_distance;
    private StringItem coord_result;
    private Spacer spacer;
    private Form temel_odev_2_form;
    private TextField azmt_dist_point_1;
    private TextField azmt_dist_point_2;
    private StringItem azmt_dist_result;
    private StringItem stringItem1;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public GUPAMIDlet() {

    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getMain_menu_list());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
        configureConsumer();
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == main_menu_list) {//GEN-BEGIN:|7-commandAction|1|38-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|38-preAction
                // write pre-action user code here
                main_menu_listAction();//GEN-LINE:|7-commandAction|2|38-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|47-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|47-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|101-preAction
        } else if (displayable == temel_odev_1_form) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|101-preAction
                // write pre-action user code here
                switchDisplayable(null, getMain_menu_list());//GEN-LINE:|7-commandAction|6|101-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|7|103-preAction
                // write pre-action user code here
                calculateCoord();//GEN-LINE:|7-commandAction|8|103-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|117-preAction
        } else if (displayable == temel_odev_2_form) {
            if (command == backCommand) {//GEN-END:|7-commandAction|9|117-preAction
                // write pre-action user code here
                switchDisplayable(null, getMain_menu_list());//GEN-LINE:|7-commandAction|10|117-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|11|118-preAction
                // write pre-action user code here
                calculateAzmtDist();//GEN-LINE:|7-commandAction|12|118-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|76-preAction
        } else if (displayable == yetki_kodu_form) {
            if (command == backCommand) {//GEN-END:|7-commandAction|13|76-preAction
                // write pre-action user code here
                switchDisplayable(null, getMain_menu_list());//GEN-LINE:|7-commandAction|14|76-postAction
                // write post-action user code here
            } else if (command == getAccessTokenCommand) {//GEN-LINE:|7-commandAction|15|78-preAction
                // write pre-action user code here
                getAccessToken();//GEN-LINE:|7-commandAction|16|78-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|56-preAction
        } else if (displayable == yetkilendir_form) {
            if (command == authorizeCommand) {//GEN-END:|7-commandAction|17|56-preAction
                // write pre-action user code here
                getRequestToken();//GEN-LINE:|7-commandAction|18|56-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|19|52-preAction
                // write pre-action user code here
                switchDisplayable(null, getMain_menu_list());//GEN-LINE:|7-commandAction|20|52-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|7-postCommandAction
        }//GEN-END:|7-commandAction|21|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|22|
    //</editor-fold>//GEN-END:|7-commandAction|22|

    public void configureConsumer(){
        String consumerKey = "lQ05aPC3AoKu2I1fXB3CjYH9lPsD7lwj";
        String consumerSecret = "2me22GVtTvMM3ESQ5LheAPeLuwesIABA";
        consumer = new GUPAConsumer(consumerKey, consumerSecret);
    }
    
    public void getRequestToken(){
        try{
            requestToken = consumer.getNewRequestToken();
        }catch(OAuthServiceProviderException e){
            Alert errorAlert = new Alert("Hata",e.toString(),null,AlertType.ERROR);
            switchDisplayable(errorAlert, getYetkilendir_form());
        }
        try{
            platformRequest(consumer.buildAuthorizeURL(requestToken.getToken()));
        }catch(ConnectionNotFoundException e){
            Alert errorAlert = new Alert("Hata",e.toString(),null,AlertType.ERROR);
            switchDisplayable(errorAlert, getYetkilendir_form());
        }
        switchDisplayable(null, getYetki_kodu_form());
    }

    public void getAccessToken(){
        requestToken.setToken(textField.getString());
        consumer.setRequestToken(requestToken);
        try{
            accessToken = consumer.getNewAccessToken();
        }catch(Exception e){
            Alert errorAlert = new Alert("Hata",e.toString(),null,AlertType.ERROR);
            errorAlert.setTimeout(3600);
            switchDisplayable(errorAlert, getYetkilendir_form());
        }
        switchDisplayable(null, getMain_menu_list());
    }

    public void calculateCoord(){
        Hashtable params = new Hashtable();
        params.put("point", coord_point.getString());
        params.put("distance", coord_distance.getString());
        params.put("azimuth", coord_azimuth.getString());
        try{
            String response = consumer.api("/basic_calc/coord", params, null);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getString("error_code").equals("0"))
                new OAuthServiceProviderException(jsonResponse.getString("error_code"));
            coord_result.setText("\n"+jsonResponse.getString("point"));
        }catch(Exception e){
            Alert errorAlert = new Alert("Hata",e.toString(),null,AlertType.ERROR);
            errorAlert.setTimeout(3600);
            switchDisplayable(errorAlert, getTemel_odev_1_form());
            e.printStackTrace();
        }
    }

    public void calculateAzmtDist(){
        Hashtable params = new Hashtable();
        params.put("point", "MULTIPOINT("+azmt_dist_point_1.getString()+", "+azmt_dist_point_2.getString()+")");
        try{
            String response = consumer.api("/basic_calc/azmt_dist", params, null);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getString("error_code").equals("0"))
                new OAuthServiceProviderException(jsonResponse.getString("error_code"));
            azmt_dist_result.setText("\nUzaklik:\n"+jsonResponse.getString("distance")+"\nAciklik Acisi:\n"+jsonResponse.getString("azimuth"));
        }catch(Exception e){
            Alert errorAlert = new Alert("Hata",e.toString(),null,AlertType.ERROR);
            errorAlert.setTimeout(3600);
            switchDisplayable(errorAlert, getTemel_odev_2_form());
            e.printStackTrace();
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Cikis", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|
    //</editor-fold>







    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: main_menu_list ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of main_menu_list component.
     * @return the initialized component instance
     */
    public List getMain_menu_list() {
        if (main_menu_list == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            main_menu_list = new List("GUPA J2ME", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
            main_menu_list.append("Uygulama Yetkilendir", null);
            main_menu_list.append("1. Temel Odev", null);
            main_menu_list.append("2. Temel Odev", null);
            main_menu_list.append("Cikis", null);
            main_menu_list.addCommand(getExitCommand());
            main_menu_list.setCommandListener(this);
            main_menu_list.setSelectedFlags(new boolean[] { false, false, false, false });//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return main_menu_list;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: main_menu_listAction ">//GEN-BEGIN:|36-action|0|36-preAction
    /**
     * Performs an action assigned to the selected list element in the main_menu_list component.
     */
    public void main_menu_listAction() {//GEN-END:|36-action|0|36-preAction
        // enter pre-action user code here
        String __selectedString = getMain_menu_list().getString(getMain_menu_list().getSelectedIndex());//GEN-BEGIN:|36-action|1|40-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Uygulama Yetkilendir")) {//GEN-END:|36-action|1|40-preAction
                // write pre-action user code here
                switchDisplayable(null, getYetkilendir_form());//GEN-LINE:|36-action|2|40-postAction
                // write post-action user code here
            } else if (__selectedString.equals("1. Temel Odev")) {//GEN-LINE:|36-action|3|41-preAction
                // write pre-action user code here
                switchDisplayable(null, getTemel_odev_1_form());//GEN-LINE:|36-action|4|41-postAction
                // write post-action user code here
            } else if (__selectedString.equals("2. Temel Odev")) {//GEN-LINE:|36-action|5|42-preAction
                // write pre-action user code here
                switchDisplayable(null, getTemel_odev_2_form());//GEN-LINE:|36-action|6|42-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Cikis")) {//GEN-LINE:|36-action|7|43-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|36-action|8|43-postAction
                // write post-action user code here
            }//GEN-BEGIN:|36-action|9|36-postAction
        }//GEN-END:|36-action|9|36-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|36-action|10|
    //</editor-fold>//GEN-END:|36-action|10|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: yetkilendir_form ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of yetkilendir_form component.
     * @return the initialized component instance
     */
    public Form getYetkilendir_form() {
        if (yetkilendir_form == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            yetkilendir_form = new Form("Uygulama Yetkilendir", new Item[] { getStringItem() });//GEN-BEGIN:|48-getter|1|48-postInit
            yetkilendir_form.addCommand(getBackCommand());
            yetkilendir_form.addCommand(getAuthorizeCommand());
            yetkilendir_form.setCommandListener(this);//GEN-END:|48-getter|1|48-postInit
            // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return yetkilendir_form;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            stringItem = new StringItem("", "Uygulama yetkilendirmek icin Yetkilendir butonuna basin.\nGeomatik Uygulamalar hesabinizla yetki vermeniz icin internet sayfasi acilcak. \nGerekli adimlari tamamladiktan sonra verilen Yeki Kodu\'nu girerek islemi tamamlayin.");//GEN-LINE:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            backCommand = new Command("Geri", Command.BACK, 0);//GEN-LINE:|51-getter|1|51-postInit
            // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|51-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: authorizeCommand ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of authorizeCommand component.
     * @return the initialized component instance
     */
    public Command getAuthorizeCommand() {
        if (authorizeCommand == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            authorizeCommand = new Command("Yetkilendir", "<null>", Command.OK, 0);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return authorizeCommand;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: yetki_kodu_form ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of yetki_kodu_form component.
     * @return the initialized component instance
     */
    public Form getYetki_kodu_form() {
        if (yetki_kodu_form == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            yetki_kodu_form = new Form("Yeki Kodunu Girin", new Item[] { getTextField() });//GEN-BEGIN:|72-getter|1|72-postInit
            yetki_kodu_form.addCommand(getBackCommand());
            yetki_kodu_form.addCommand(getGetAccessTokenCommand());
            yetki_kodu_form.setCommandListener(this);//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return yetki_kodu_form;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: getAccessTokenCommand ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initiliazed instance of getAccessTokenCommand component.
     * @return the initialized component instance
     */
    public Command getGetAccessTokenCommand() {
        if (getAccessTokenCommand == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            getAccessTokenCommand = new Command("Tamam", Command.OK, 0);//GEN-LINE:|77-getter|1|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|2|
        return getAccessTokenCommand;
    }
    //</editor-fold>//GEN-END:|77-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
            textField = new TextField("Yetki Kodu:", "", 32, TextField.ANY);//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
        }//GEN-BEGIN:|73-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|73-getter|2|







    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temel_odev_1_form ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initiliazed instance of temel_odev_1_form component.
     * @return the initialized component instance
     */
    public Form getTemel_odev_1_form() {
        if (temel_odev_1_form == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            temel_odev_1_form = new Form("1. Temel Odev", new Item[] { getCoord_point(), getCoord_distance(), getCoord_azimuth(), getSpacer(), getCoord_result() });//GEN-BEGIN:|92-getter|1|92-postInit
            temel_odev_1_form.addCommand(getBackCommand());
            temel_odev_1_form.addCommand(getOkCommand());
            temel_odev_1_form.setCommandListener(this);//GEN-END:|92-getter|1|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return temel_odev_1_form;
    }
    //</editor-fold>//GEN-END:|92-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: coord_point ">//GEN-BEGIN:|98-getter|0|98-preInit
    /**
     * Returns an initiliazed instance of coord_point component.
     * @return the initialized component instance
     */
    public TextField getCoord_point() {
        if (coord_point == null) {//GEN-END:|98-getter|0|98-preInit
            // write pre-init user code here
            coord_point = new TextField("1. Nokta", "POINT(1000.0 1000.0)", 32, TextField.ANY);//GEN-LINE:|98-getter|1|98-postInit
            // write post-init user code here
        }//GEN-BEGIN:|98-getter|2|
        return coord_point;
    }
    //</editor-fold>//GEN-END:|98-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            okCommand = new Command("Hesapla", Command.OK, 0);//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|102-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: coord_distance ">//GEN-BEGIN:|99-getter|0|99-preInit
    /**
     * Returns an initiliazed instance of coord_distance component.
     * @return the initialized component instance
     */
    public TextField getCoord_distance() {
        if (coord_distance == null) {//GEN-END:|99-getter|0|99-preInit
            // write pre-init user code here
            coord_distance = new TextField("Uzaklik", "121.26", 32, TextField.ANY);//GEN-LINE:|99-getter|1|99-postInit
            // write post-init user code here
        }//GEN-BEGIN:|99-getter|2|
        return coord_distance;
    }
    //</editor-fold>//GEN-END:|99-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: coord_azimuth ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of coord_azimuth component.
     * @return the initialized component instance
     */
    public TextField getCoord_azimuth() {
        if (coord_azimuth == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            coord_azimuth = new TextField("Aciklik Acisi", "168.3460", 32, TextField.ANY);//GEN-LINE:|100-getter|1|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|2|
        return coord_azimuth;
    }
    //</editor-fold>//GEN-END:|100-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|109-getter|0|109-preInit
    /**
     * Returns an initiliazed instance of spacer component.
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            spacer = new Spacer(16, 1);//GEN-LINE:|109-getter|1|109-postInit
            // write post-init user code here
        }//GEN-BEGIN:|109-getter|2|
        return spacer;
    }
    //</editor-fold>//GEN-END:|109-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: coord_result ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of coord_result component.
     * @return the initialized component instance
     */
    public StringItem getCoord_result() {
        if (coord_result == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            coord_result = new StringItem("Sonuc:", "");//GEN-LINE:|110-getter|1|110-postInit
            // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return coord_result;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temel_odev_2_form ">//GEN-BEGIN:|112-getter|0|112-preInit
    /**
     * Returns an initiliazed instance of temel_odev_2_form component.
     * @return the initialized component instance
     */
    public Form getTemel_odev_2_form() {
        if (temel_odev_2_form == null) {//GEN-END:|112-getter|0|112-preInit
            // write pre-init user code here
            temel_odev_2_form = new Form("2. Temel Odev", new Item[] { getStringItem1(), getAzmt_dist_point_1(), getAzmt_dist_point_2(), getAzmt_dist_result() });//GEN-BEGIN:|112-getter|1|112-postInit
            temel_odev_2_form.addCommand(getBackCommand());
            temel_odev_2_form.addCommand(getOkCommand());
            temel_odev_2_form.setCommandListener(this);//GEN-END:|112-getter|1|112-postInit
            // write post-init user code here
        }//GEN-BEGIN:|112-getter|2|
        return temel_odev_2_form;
    }
    //</editor-fold>//GEN-END:|112-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: azmt_dist_point_1 ">//GEN-BEGIN:|113-getter|0|113-preInit
    /**
     * Returns an initiliazed instance of azmt_dist_point_1 component.
     * @return the initialized component instance
     */
    public TextField getAzmt_dist_point_1() {
        if (azmt_dist_point_1 == null) {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            azmt_dist_point_1 = new TextField("1. Nokta", "", 32, TextField.ANY);//GEN-LINE:|113-getter|1|113-postInit
            // write post-init user code here
        }//GEN-BEGIN:|113-getter|2|
        return azmt_dist_point_1;
    }
    //</editor-fold>//GEN-END:|113-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: azmt_dist_point_2 ">//GEN-BEGIN:|114-getter|0|114-preInit
    /**
     * Returns an initiliazed instance of azmt_dist_point_2 component.
     * @return the initialized component instance
     */
    public TextField getAzmt_dist_point_2() {
        if (azmt_dist_point_2 == null) {//GEN-END:|114-getter|0|114-preInit
            // write pre-init user code here
            azmt_dist_point_2 = new TextField("2. Nokta", "", 32, TextField.ANY);//GEN-LINE:|114-getter|1|114-postInit
            // write post-init user code here
        }//GEN-BEGIN:|114-getter|2|
        return azmt_dist_point_2;
    }
    //</editor-fold>//GEN-END:|114-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: azmt_dist_result ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of azmt_dist_result component.
     * @return the initialized component instance
     */
    public StringItem getAzmt_dist_result() {
        if (azmt_dist_result == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            azmt_dist_result = new StringItem("Sonuc:", "");//GEN-LINE:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return azmt_dist_result;
    }
    //</editor-fold>//GEN-END:|115-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("", "Noktalari girerken sayilar arasinda bir bosluk birakin.\nOrnek: 1000 1020");//GEN-LINE:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|122-getter|2|









    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
