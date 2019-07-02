package de.exxcellent.challenge.data;


/**
 * Weather data object with all attributes of the csv file
 */
public class Weather {
	
	private int day;
	private double mxt;
	private double mnt;
	private double avt;
	private double avdp;
	private double hrptpcpn;
	private double pdir;
	private double avsp;
	private double dir;
	private double mxs;
	private double skyc;
	private double mxr;
	private double mn;
	private double ravslp;
	private static final String seperator = ",";
	private static final String structure = "Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP";
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getMxt() {
		return mxt;
	}

	public void setMxt(double mxt) {
		this.mxt = mxt;
	}

	public double getMnt() {
		return mnt;
	}

	public void setMnt(double mnt) {
		this.mnt = mnt;
	}

	public double getAvt() {
		return avt;
	}

	public void setAvt(double avt) {
		this.avt = avt;
	}

	public double getAvdp() {
		return avdp;
	}

	public void setAvdp(double avdp) {
		this.avdp = avdp;
	}

	public double getHrptpcpn() {
		return hrptpcpn;
	}

	public void setHrptpcpn(double hrptpcpn) {
		this.hrptpcpn = hrptpcpn;
	}

	public double getPdir() {
		return pdir;
	}

	public void setPdir(double pdir) {
		this.pdir = pdir;
	}

	public double getAvsp() {
		return avsp;
	}

	public void setAvsp(double avsp) {
		this.avsp = avsp;
	}

	public double getDir() {
		return dir;
	}

	public void setDir(double dir) {
		this.dir = dir;
	}

	public double getMxs() {
		return mxs;
	}

	public void setMxs(double mxs) {
		this.mxs = mxs;
	}

	public double getSkyc() {
		return skyc;
	}

	public void setSkyc(double skyc) {
		this.skyc = skyc;
	}

	public double getMxr() {
		return mxr;
	}

	public void setMxr(double mxr) {
		this.mxr = mxr;
	}

	public double getMn() {
		return mn;
	}

	public void setMn(double mn) {
		this.mn = mn;
	}

	public double getRavslp() {
		return ravslp;
	}

	public void setRavslp(double ravslp) {
		this.ravslp = ravslp;
	}

	public static String getSeperator() {
		return seperator;
	}	
	
	public static String getStructure(){
		return structure;
	}
	
	public static int getNumberofColumns(){
		return getStructure().split(getSeperator()).length;
	}
	
	
	
}

