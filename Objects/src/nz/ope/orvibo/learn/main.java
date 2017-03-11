package nz.ope.orvibo.learn;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("nz.ope.orvibo.learn", "nz.ope.orvibo.learn.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "nz.ope.orvibo.learn.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            if (!false)
                System.setProperty("prism.lcdtext", "false");
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 605, 470);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static String _hostip = "";
public static String _ip = "";
public static String _mac = "";
public static String _magicword = "";
public static String _twenties = "";
public static String _localpassword = "";
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket1 = null;
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _b = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnsubscribe = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnfindusingmac = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _txtip = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _txtmac = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _txtir = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _txtlog = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnlearnmode = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btncopy = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnsendir = null;
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
com.tchart.jutilities.jUtilities _u = null;
 //BA.debugLineNum = 40;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 41;BA.debugLine="Dim u As jUtilities";
_u = new com.tchart.jutilities.jUtilities();
 //BA.debugLineNum = 43;BA.debugLine="HostIP = u.HostAddress";
_hostip = _u.getHostAddress();
 //BA.debugLineNum = 45;BA.debugLine="UDPSocket1.Initialize(\"UDP\", 10000, 1000)";
_udpsocket1.Initialize(ba,"UDP",(int) (10000),(int) (1000));
 //BA.debugLineNum = 47;BA.debugLine="MainForm = Form1";
_mainform = _form1;
 //BA.debugLineNum = 48;BA.debugLine="MainForm.Resizable = False";
_mainform.setResizable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 49;BA.debugLine="MainForm.SetFormStyle(\"UNIFIED\")";
_mainform.SetFormStyle("UNIFIED");
 //BA.debugLineNum = 50;BA.debugLine="MainForm.RootPane.LoadLayout(\"Layout1\") 'Load the";
_mainform.getRootPane().LoadLayout(ba,"Layout1");
 //BA.debugLineNum = 52;BA.debugLine="txtIP.Text = ip";
_txtip.setText(_ip);
 //BA.debugLineNum = 53;BA.debugLine="txtMAC.Text = Mac";
_txtmac.setText(_mac);
 //BA.debugLineNum = 54;BA.debugLine="txtIR.Text = \"\"";
_txtir.setText("");
 //BA.debugLineNum = 55;BA.debugLine="txtLog.Text = \"Host IP = \" & HostIP";
_txtlog.setText("Host IP = "+_hostip);
 //BA.debugLineNum = 57;BA.debugLine="MainForm.Show";
_mainform.Show();
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _btncopy_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Sub btnCopy_MouseClicked (EventData As MouseEvent)";
 //BA.debugLineNum = 332;BA.debugLine="PopulateValues";
_populatevalues();
 //BA.debugLineNum = 334;BA.debugLine="fx.Clipboard.SetString(txtIR.Text)";
_fx.Clipboard.SetString(_txtir.getText());
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public static String  _btnfindusingmac_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Sub btnFindUsingMAC_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 317;BA.debugLine="PopulateValues";
_populatevalues();
 //BA.debugLineNum = 318;BA.debugLine="End Sub";
return "";
}
public static String  _btnlearnmode_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
String _msg = "";
 //BA.debugLineNum = 320;BA.debugLine="Sub btnLearnMode_MouseClicked (EventData As MouseE";
 //BA.debugLineNum = 321;BA.debugLine="PopulateValues";
_populatevalues();
 //BA.debugLineNum = 323;BA.debugLine="txtIR.Text = \"\"";
_txtir.setText("");
 //BA.debugLineNum = 326;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 327;BA.debugLine="msg = \"6C73\" & Mac & twenties & \"010000000000\"";
_msg = "6C73"+_mac+_twenties+"010000000000";
 //BA.debugLineNum = 328;BA.debugLine="SendPacket(msg)";
_sendpacket(_msg);
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
return "";
}
public static String  _btnsendir_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
String _msg = "";
 //BA.debugLineNum = 337;BA.debugLine="Sub btnSendIR_MouseClicked (EventData As MouseEven";
 //BA.debugLineNum = 338;BA.debugLine="If txtIR.Text = \"\" Then Return";
if ((_txtir.getText()).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 340;BA.debugLine="PopulateValues";
_populatevalues();
 //BA.debugLineNum = 342;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 343;BA.debugLine="msg = PrepareIR(txtIR.Text)";
_msg = _prepareir(_txtir.getText());
 //BA.debugLineNum = 344;BA.debugLine="SendPacket(msg)";
_sendpacket(_msg);
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public static String  _btnsubscribe_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
String _msg = "";
 //BA.debugLineNum = 306;BA.debugLine="Sub btnSubscribe_MouseClicked (EventData As MouseE";
 //BA.debugLineNum = 307;BA.debugLine="PopulateValues";
_populatevalues();
 //BA.debugLineNum = 311;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 312;BA.debugLine="msg = \"636C\" & Mac & twenties & LocalPassword & t";
_msg = "636C"+_mac+_twenties+_localpassword+_twenties;
 //BA.debugLineNum = 313;BA.debugLine="SendPacket(msg)";
_sendpacket(_msg);
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public static String  _hexpacketlength(String _pack) throws Exception{
int _l = 0;
String _lengthhex = "";
 //BA.debugLineNum = 82;BA.debugLine="Sub HexPacketLength(Pack As String) As String";
 //BA.debugLineNum = 83;BA.debugLine="Dim l As Int";
_l = 0;
 //BA.debugLineNum = 84;BA.debugLine="l = Pack.Length/2";
_l = (int) (_pack.length()/(double)2);
 //BA.debugLineNum = 85;BA.debugLine="l = l + 4";
_l = (int) (_l+4);
 //BA.debugLineNum = 87;BA.debugLine="Dim lengthhex As String";
_lengthhex = "";
 //BA.debugLineNum = 88;BA.debugLine="lengthhex = Bit.ToHexString(l).ToUpperCase";
_lengthhex = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(_l).toUpperCase();
 //BA.debugLineNum = 90;BA.debugLine="Do While lengthhex.Length < 4";
while (_lengthhex.length()<4) {
 //BA.debugLineNum = 91;BA.debugLine="lengthhex = \"0\" & lengthhex";
_lengthhex = "0"+_lengthhex;
 }
;
 //BA.debugLineNum = 96;BA.debugLine="Return lengthhex";
if (true) return _lengthhex;
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _populatevalues() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub PopulateValues()";
 //BA.debugLineNum = 61;BA.debugLine="ip = txtIP.Text";
_ip = _txtip.getText();
 //BA.debugLineNum = 62;BA.debugLine="Mac = txtMAC.Text";
_mac = _txtmac.getText();
 //BA.debugLineNum = 64;BA.debugLine="LocalPassword = ReverseHex(Mac)";
_localpassword = _reversehex(_mac);
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _prepareir(String _rawir) throws Exception{
String _randombita = "";
String _randombitb = "";
int _irlength = 0;
String _irlengthhex = "";
String _msg = "";
String _fullir = "";
 //BA.debugLineNum = 347;BA.debugLine="Sub PrepareIR(RawIR As String) As String";
 //BA.debugLineNum = 348;BA.debugLine="Dim RandomBitA As String = Bit.ToHexString(Rnd(0,";
_randombita = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255))).toUpperCase();
 //BA.debugLineNum = 349;BA.debugLine="Dim RandomBitB As String = Bit.ToHexString(Rnd(0,";
_randombitb = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255))).toUpperCase();
 //BA.debugLineNum = 351;BA.debugLine="If RandomBitA.Length < 2 Then RandomBitA = \"0\" &";
if (_randombita.length()<2) { 
_randombita = "0"+_randombita;};
 //BA.debugLineNum = 352;BA.debugLine="If RandomBitB.Length < 2 Then RandomBitB = \"0\" &";
if (_randombitb.length()<2) { 
_randombitb = "0"+_randombitb;};
 //BA.debugLineNum = 354;BA.debugLine="Dim irlength As Int";
_irlength = 0;
 //BA.debugLineNum = 355;BA.debugLine="irlength = RawIR.Length/2";
_irlength = (int) (_rawir.length()/(double)2);
 //BA.debugLineNum = 357;BA.debugLine="Dim irlengthhex As String";
_irlengthhex = "";
 //BA.debugLineNum = 358;BA.debugLine="irlengthhex = Bit.ToHexString(irlength).ToUpperCa";
_irlengthhex = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(_irlength).toUpperCase();
 //BA.debugLineNum = 360;BA.debugLine="Do While irlengthhex.Length < 4";
while (_irlengthhex.length()<4) {
 //BA.debugLineNum = 361;BA.debugLine="irlengthhex = \"0\" & irlengthhex";
_irlengthhex = "0"+_irlengthhex;
 }
;
 //BA.debugLineNum = 364;BA.debugLine="irlengthhex = ReverseHex(irlengthhex)";
_irlengthhex = _reversehex(_irlengthhex);
 //BA.debugLineNum = 366;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 367;BA.debugLine="msg = \"6963\" & Mac & twenties & \"65000000\" & Rand";
_msg = "6963"+_mac+_twenties+"65000000"+_randombita+_randombitb+_irlengthhex+_rawir;
 //BA.debugLineNum = 369;BA.debugLine="Dim fullir As String";
_fullir = "";
 //BA.debugLineNum = 371;BA.debugLine="fullir = msg";
_fullir = _msg;
 //BA.debugLineNum = 373;BA.debugLine="tLog(\"fullir = \" & fullir)";
_tlog("fullir = "+_fullir);
 //BA.debugLineNum = 375;BA.debugLine="Return fullir";
if (true) return _fullir;
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 8;BA.debugLine="Private MainForm As Form";
_mainform = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 10;BA.debugLine="Dim HostIP As String";
_hostip = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim ip As String = \"192.168.178.2\"";
_ip = "192.168.178.2";
 //BA.debugLineNum = 17;BA.debugLine="Dim Mac As String = \"ACCF00000000\"";
_mac = "ACCF00000000";
 //BA.debugLineNum = 19;BA.debugLine="Dim magicWord As String = \"6864\"";
_magicword = "6864";
 //BA.debugLineNum = 20;BA.debugLine="Dim twenties As String = \"202020202020\"";
_twenties = "202020202020";
 //BA.debugLineNum = 22;BA.debugLine="Dim LocalPassword As String = \"\"";
_localpassword = "";
 //BA.debugLineNum = 24;BA.debugLine="Dim UDPSocket1 As UDPSocket";
_udpsocket1 = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 25;BA.debugLine="Dim b As ByteConverter";
_b = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 27;BA.debugLine="Private btnSubscribe As Button";
_btnsubscribe = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btnFindUsingMAC As Button";
_btnfindusingmac = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private txtIP As TextField";
_txtip = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private txtMAC As TextField";
_txtmac = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private txtIR As TextArea";
_txtir = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private txtLog As TextArea";
_txtlog = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private btnLearnMode As Button";
_btnlearnmode = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private btnCopy As Button";
_btncopy = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private btnSendIR As Button";
_btnsendir = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _reversehex(String _hex) throws Exception{
String _hexrev = "";
int _i = 0;
 //BA.debugLineNum = 72;BA.debugLine="Sub ReverseHex(Hex As String) As String";
 //BA.debugLineNum = 73;BA.debugLine="Dim HexRev As String";
_hexrev = "";
 //BA.debugLineNum = 75;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 76;BA.debugLine="For i = 0 To Hex.Length -1 Step 2";
{
final int step3 = (int) (2);
final int limit3 = (int) (_hex.length()-1);
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 77;BA.debugLine="HexRev = Hex.CharAt(i) & Hex.CharAt(i+1) &";
_hexrev = BA.ObjectToString(_hex.charAt(_i))+BA.ObjectToString(_hex.charAt((int) (_i+1)))+_hexrev;
 }
};
 //BA.debugLineNum = 79;BA.debugLine="Return HexRev";
if (true) return _hexrev;
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _sendpacket(String _msg) throws Exception{
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
 //BA.debugLineNum = 99;BA.debugLine="Sub SendPacket(msg As String)";
 //BA.debugLineNum = 100;BA.debugLine="tLog(msg)";
_tlog(_msg);
 //BA.debugLineNum = 101;BA.debugLine="tLog(\"Packet=\" & magicWord & HexPacketLength(msg)";
_tlog("Packet="+_magicword+_hexpacketlength(_msg)+_msg);
 //BA.debugLineNum = 103;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
 //BA.debugLineNum = 104;BA.debugLine="Packet.Initialize(b.HexToBytes(magicWord & Hex";
_packet.Initialize(_b.HexToBytes(_magicword+_hexpacketlength(_msg)+_msg),_ip,(int) (10000));
 //BA.debugLineNum = 106;BA.debugLine="UDPSocket1.Send(Packet)";
_udpsocket1.Send(_packet);
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static String  _tlog(String _text) throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Sub tLog(Text As String)";
 //BA.debugLineNum = 68;BA.debugLine="txtLog.Text = txtLog.Text & CRLF & Text";
_txtlog.setText(_txtlog.getText()+anywheresoftware.b4a.keywords.Common.CRLF+_text);
 //BA.debugLineNum = 69;BA.debugLine="txtLog.SetSelection(txtLog.Text.Length, txtLog.Te";
_txtlog.SetSelection(_txtlog.getText().length(),_txtlog.getText().length());
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
int _packetlength = 0;
String _messagehex = "";
String _responsetype = "";
String _msg = "";
String _macaddress = "";
String[] _components = null;
int _n = 0;
String _lastcomponent = "";
String _table_number = "";
 //BA.debugLineNum = 109;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
 //BA.debugLineNum = 110;BA.debugLine="If Packet.HostAddress <> HostIP Then";
if ((_packet.getHostAddress()).equals(_hostip) == false) { 
 //BA.debugLineNum = 111;BA.debugLine="tLog(\"*********************************\")";
_tlog("*********************************");
 //BA.debugLineNum = 112;BA.debugLine="tLog(\"From: \" & Packet.HostAddress)";
_tlog("From: "+_packet.getHostAddress());
 //BA.debugLineNum = 113;BA.debugLine="tLog(\"*********************************\")";
_tlog("*********************************");
 //BA.debugLineNum = 115;BA.debugLine="Dim PacketLength As Int = Packet.Length";
_packetlength = _packet.getLength();
 //BA.debugLineNum = 117;BA.debugLine="tLog(\"Packet length = \" & PacketLength)";
_tlog("Packet length = "+BA.NumberToString(_packetlength));
 //BA.debugLineNum = 119;BA.debugLine="Dim b As ByteConverter";
_b = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 120;BA.debugLine="Dim MessageHex As String = b.HexFromBytes(Packet";
_messagehex = _b.HexFromBytes(_packet.getData());
 //BA.debugLineNum = 122;BA.debugLine="MessageHex = MessageHex.SubString2(0,PacketLengt";
_messagehex = _messagehex.substring((int) (0),(int) (_packetlength*2));
 //BA.debugLineNum = 124;BA.debugLine="tLog(\"MessageHex = \" & MessageHex)";
_tlog("MessageHex = "+_messagehex);
 //BA.debugLineNum = 126;BA.debugLine="Dim ResponseType As String = MessageHex.SubStrin";
_responsetype = _messagehex.substring((int) (8),(int) (12));
 //BA.debugLineNum = 127;BA.debugLine="tLog(ResponseType & \" \" & BytesToString(Packet.D";
_tlog(_responsetype+" "+anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),(int) (4),(int) (2),"UTF8"));
 //BA.debugLineNum = 129;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 130;BA.debugLine="msg = BytesToString(Packet.Data, Packet.Offset,";
_msg = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
 //BA.debugLineNum = 131;BA.debugLine="tLog(\"msg = \" & msg)";
_tlog("msg = "+_msg);
 //BA.debugLineNum = 135;BA.debugLine="If MessageHex.IndexOf(\"ACCF\") > 0 Then";
if (_messagehex.indexOf("ACCF")>0) { 
 //BA.debugLineNum = 136;BA.debugLine="Dim macAddress As String = MessageHex.SubString";
_macaddress = _messagehex.substring(_messagehex.indexOf("ACCF"),(int) (_messagehex.indexOf("ACCF")+12));
 //BA.debugLineNum = 137;BA.debugLine="tLog(\"From MAC: \" & macAddress)";
_tlog("From MAC: "+_macaddress);
 //BA.debugLineNum = 165;BA.debugLine="If ResponseType = \"7161\" Then";
if ((_responsetype).equals("7161")) { 
 //BA.debugLineNum = 166;BA.debugLine="Log(ResponseType & \" [Device Type]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [Device Type]");
 //BA.debugLineNum = 168;BA.debugLine="Dim components() As String";
_components = new String[(int) (0)];
java.util.Arrays.fill(_components,"");
 //BA.debugLineNum = 169;BA.debugLine="components = Regex.split(twenties,MessageHex)";
_components = anywheresoftware.b4a.keywords.Common.Regex.Split(_twenties,_messagehex);
 //BA.debugLineNum = 171;BA.debugLine="Log(\"Type: \" & b.StringFromBytes(b.HexToBytes(";
anywheresoftware.b4a.keywords.Common.Log("Type: "+_b.StringFromBytes(_b.HexToBytes(_components[(int) (2)].substring((int) (0),(int) (12))),"UTF8"));
 };
 //BA.debugLineNum = 181;BA.debugLine="If ResponseType = \"636C\" Then";
if ((_responsetype).equals("636C")) { 
 //BA.debugLineNum = 182;BA.debugLine="Log(ResponseType & \" [Subscribed]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [Subscribed]");
 //BA.debugLineNum = 184;BA.debugLine="Dim components() As String";
_components = new String[(int) (0)];
java.util.Arrays.fill(_components,"");
 //BA.debugLineNum = 185;BA.debugLine="components = Regex.split(twenties,MessageHex)";
_components = anywheresoftware.b4a.keywords.Common.Regex.Split(_twenties,_messagehex);
 //BA.debugLineNum = 187;BA.debugLine="If components(1).Length > 11 Then Log(\"State:";
if (_components[(int) (1)].length()>11) { 
anywheresoftware.b4a.keywords.Common.Log("State: "+_components[(int) (1)].substring((int) (11),(int) (12)));};
 };
 //BA.debugLineNum = 191;BA.debugLine="If ResponseType = \"7366\" Then";
if ((_responsetype).equals("7366")) { 
 //BA.debugLineNum = 192;BA.debugLine="Log(ResponseType & \" [State Change]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [State Change]");
 //BA.debugLineNum = 194;BA.debugLine="Dim components() As String";
_components = new String[(int) (0)];
java.util.Arrays.fill(_components,"");
 //BA.debugLineNum = 195;BA.debugLine="components = Regex.split(twenties,MessageHex)";
_components = anywheresoftware.b4a.keywords.Common.Regex.Split(_twenties,_messagehex);
 //BA.debugLineNum = 197;BA.debugLine="Log(\"State: \" & components(1).SubString2(9,10)";
anywheresoftware.b4a.keywords.Common.Log("State: "+_components[(int) (1)].substring((int) (9),(int) (10)));
 };
 //BA.debugLineNum = 201;BA.debugLine="If ResponseType = \"6469\" Then";
if ((_responsetype).equals("6469")) { 
 //BA.debugLineNum = 202;BA.debugLine="Log(ResponseType & \" [Putton Press]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [Putton Press]");
 };
 //BA.debugLineNum = 206;BA.debugLine="If ResponseType = \"7167\" Then";
if ((_responsetype).equals("7167")) { 
 //BA.debugLineNum = 207;BA.debugLine="Log(ResponseType & \" [Search where Mac Is know";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [Search where Mac Is known]");
 };
 //BA.debugLineNum = 211;BA.debugLine="If ResponseType = \"7274\" Then";
if ((_responsetype).equals("7274")) { 
 //BA.debugLineNum = 212;BA.debugLine="Log(ResponseType & \" [Table]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [Table]");
 //BA.debugLineNum = 214;BA.debugLine="Dim components() As String";
_components = new String[(int) (0)];
java.util.Arrays.fill(_components,"");
 //BA.debugLineNum = 215;BA.debugLine="components = Regex.split(twenties,MessageHex)";
_components = anywheresoftware.b4a.keywords.Common.Regex.Split(_twenties,_messagehex);
 //BA.debugLineNum = 217;BA.debugLine="Log(\"Components = \" & components.Length)";
anywheresoftware.b4a.keywords.Common.Log("Components = "+BA.NumberToString(_components.length));
 //BA.debugLineNum = 239;BA.debugLine="Dim n As Int";
_n = 0;
 //BA.debugLineNum = 240;BA.debugLine="For n = 0 To components.Length -1";
{
final int step49 = 1;
final int limit49 = (int) (_components.length-1);
for (_n = (int) (0) ; (step49 > 0 && _n <= limit49) || (step49 < 0 && _n >= limit49); _n = ((int)(0 + _n + step49)) ) {
 //BA.debugLineNum = 241;BA.debugLine="Log(n & \") - \" & b.StringFromBytes(b.HexToByt";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_n)+") - "+_b.StringFromBytes(_b.HexToBytes(_components[_n]),"UTF8")+" ["+_components[_n]+"]");
 }
};
 //BA.debugLineNum = 244;BA.debugLine="Dim LastComponent As String";
_lastcomponent = "";
 //BA.debugLineNum = 245;BA.debugLine="LastComponent = components(components.Length-1";
_lastcomponent = _components[(int) (_components.length-1)];
 //BA.debugLineNum = 247;BA.debugLine="Dim table_number As String";
_table_number = "";
 //BA.debugLineNum = 248;BA.debugLine="table_number = LastComponent.SubString2(0,2)";
_table_number = _lastcomponent.substring((int) (0),(int) (2));
 //BA.debugLineNum = 250;BA.debugLine="Log(\"table_number = \" & table_number)";
anywheresoftware.b4a.keywords.Common.Log("table_number = "+_table_number);
 };
 //BA.debugLineNum = 283;BA.debugLine="If ResponseType = \"6963\" Then";
if ((_responsetype).equals("6963")) { 
 //BA.debugLineNum = 284;BA.debugLine="Log(ResponseType & \" [IR Done]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [IR Done]");
 };
 //BA.debugLineNum = 288;BA.debugLine="If ResponseType = \"6C73\" Then";
if ((_responsetype).equals("6C73")) { 
 //BA.debugLineNum = 289;BA.debugLine="Log(ResponseType & \" [IR Code Received]\")";
anywheresoftware.b4a.keywords.Common.Log(_responsetype+" [IR Code Received]");
 //BA.debugLineNum = 291;BA.debugLine="If MessageHex.Length >= 52 Then";
if (_messagehex.length()>=52) { 
 //BA.debugLineNum = 292;BA.debugLine="txtIR.Text = MessageHex.SubString(52)";
_txtir.setText(_messagehex.substring((int) (52)));
 };
 };
 };
 };
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
}
