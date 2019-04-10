package freemakerdemo;

import java.io.Serializable;
import java.util.List;

/**
 * @description 需要总账支持的业务单据DTO类
 * @author jiaozl
 * @date 2016-04-05
 * @version: V1.0
 */
@SuppressWarnings("serial")
public class VoucherDTO //extends WFBussiDTOBase  
{
	/**
	 * 
	 */

	public VoucherDTO()
	{
	}

	/**
	 * 行政区划。
	 */
	private int admDiv;

	/**
	 * 凭证编码
	 */
	private String vtCode;

	/**
	 * 发送方
	 */
	private String srcOrgType;

	/**
	 * 接收方
	 */
	private String decOrgType;

	// ------------------------

	public String getSrcOrgType()
	{
		return srcOrgType;
	}

	public void setSrcOrgType(String srcOrgType)
	{
		this.srcOrgType = srcOrgType;
	}

	public String getDecOrgType()
	{
		return decOrgType;
	}

	public void setDecOrgType(String decOrgType)
	{
		this.decOrgType = decOrgType;
	}

	public String getVtCode()
	{
		return vtCode;
	}

	public void setVtcode(String vtcode)
	{
		this.vtCode = vtcode;
	}

	/**
	 * 业务处理方向（来源、目的）
	 */
	private int busiDirect;

	public int getBusiDirect()
	{
		return busiDirect;
	}

	public void setBusiDirect(int busiDirect)
	{
		this.busiDirect = busiDirect;
	}

	private String billMemo;
	private String billCreateDate;
	private String billCreateUser;
	private String billLastDate;
	private String billLastUser;
	private int glVchClsId;

	/**
	 * 凭证来源类型(0界面手工1轮询2回退9绿色通道)
	 */
	private int veSourceType;

	public int getVeSourceType()
	{
		return veSourceType;
	}

	public void setVeSourceType(int veSourceType)
	{
		this.veSourceType = veSourceType;
	}

	/**
	 * 电子凭证库数据
	 */
	//private VoucherExDTO voucherExchangeTag;

	/**
	 * 政府支出管理结构
	 */
	private int expStr;

	/**
	 * 指标流向
	 */
	private int bgtDir;

	/**
	 * 控制类型
	 */
	private int controlType;

	/**
	 * 年初预算编码
	 */
	private String inDepProCode;

	/**
	 * 添加单据类型字段，用户区分是否为退单
	 */
	private int billType;

	/**
	 * 动作号
	 */
	private int wfActionId;

	/**
	 * 记账日期
	 */
	private String glBusiDate;

	/**
	 * 单据定义号。
	 */
	private int voucherId;

	/**
	 * 预算年度。
	 */
	private int bdgYear;

	/**
	 * 计划月份。
	 */
	private int planMonth;

	/**
	 * 业务归口处。
	 */
	private int depDiv;

	/**
	 * 指标管理处。
	 */
	private int bdgManageDiv;

	/**
	 * 财政管理级次标识。
	 */
	private int finadmLevel;

	/**
	 * 预算部门。
	 */
	private int supDep;

	/**
	 * 预算单位。
	 */
	private int agency;

	/**
	 * 资金性质。
	 */
	private int fundType;

	/**
	 * 支出类别。
	 */
	private int expType;

	/**
	 * 支出功能分类。
	 */
	private int expFunc;

	/**
	 * 支出经济分类。
	 */
	private int expEco;

	private int expEcoDetail;

	public int getExpEcoDetail()
	{
		return expEcoDetail;
	}

	public void setExpEcoDetail(int expEcoDetail)
	{
		this.expEcoDetail = expEcoDetail;
	}

	/**
	 * 支出细目。
	 */
	private int expDetail;

	public int getExpDetail()
	{
		return expDetail;
	}

	public void setExpDetail(int expDetail)
	{
		this.expDetail = expDetail;
	}

	/**
	 * 资金属性。
	 */
	private int expFundType;

	/**
	 * 预算来源。
	 */
	private int bgtSource;

	/**
	 * 预算来源性质。
	 */
	private int indSource;

	/**
	 * 预算收入类型。
	 */
	private int incomeType;

	/// <summary>
	/// 收入分类科目。
	/// </summary>
	private int incomeSort;

	/// <summary>
	/// 预算单位收入来源。
	/// </summary>
	private int agencyInc;

	/// <summary>
	/// 乡镇收入来源。
	/// </summary>
	private int villagesInc;

	/// <summary>
	/// 专户项目类型。
	/// </summary>
	private int specialAccType;

	/// <summary>
	/// 专户收入来源。
	/// </summary>
	private int specialAccInc;

	/// <summary>
	/// 指标文号。
	/// </summary>
	private String bgtDocNo;

	/// <summary>
	/// 指标项目编码。
	/// </summary>
	private String depProCode;

	// 单据状态
	private int billStatus;

	// 政府采购类型
	private int gpType;

	private int isReturn;

	public int getIsReturn()
	{
		return isReturn;
	}

	public void setIsReturn(int isReturn)
	{
		this.isReturn = isReturn;
	}

	public int getGpType()
	{
		return gpType;
	}

	public void setGpType(int gpType)
	{
		this.gpType = gpType;
	}

	public int getBillStatus()
	{
		return billStatus;
	}

	public void setBillStatus(int billStatus)
	{
		this.billStatus = billStatus;
	}

	public String getBillCreateDate()
	{
		return billCreateDate;
	}

	public void setBillCreateDate(String billCreateDate)
	{
		this.billCreateDate = billCreateDate;
	}

	public String getBillCreateUser()
	{
		return billCreateUser;
	}

	public void setBillCreateUser(String billCreateUser)
	{
		this.billCreateUser = billCreateUser;
	}

	public String getBillLastDate()
	{
		return billLastDate;
	}

	public void setBillLastDate(String billLastDate)
	{
		this.billLastDate = billLastDate;
	}

	public String getBillLastUser()
	{
		return billLastUser;
	}

	public void setBillLastUser(String billLastUser)
	{
		this.billLastUser = billLastUser;
	}

	public int getGlVchClsId()
	{
		return glVchClsId;
	}

	public void setGlVchClsId(int glVchClsId)
	{
		this.glVchClsId = glVchClsId;
	}

	public String getInDepProCode()
	{
		return inDepProCode;
	}

	public void setInDepProCode(String inDepProCode)
	{
		this.inDepProCode = inDepProCode;
	}

	public String getDepProCode()
	{
		return depProCode;
	}

	public void setDepProCode(String depProCode)
	{
		this.depProCode = depProCode;
	}

	public String getDepProName()
	{
		return depProName;
	}

	public void setDepProName(String depProName)
	{
		this.depProName = depProName;
	}

	public String getBgtProjCode()
	{
		return bgtProjCode;
	}

	public void setBgtProjCode(String bgtProjCode)
	{
		this.bgtProjCode = bgtProjCode;
	}

	public String getBgtProjName()
	{
		return bgtProjName;
	}

	public void setBgtProjName(String bgtProjName)
	{
		this.bgtProjName = bgtProjName;
	}

	public int getCcid()
	{
		return ccid;
	}

	public void setCcid(int ccid)
	{
		this.ccid = ccid;
	}

	public int getSfAccount()
	{
		return sfAccount;
	}

	public void setSfAccount(int sfAccount)
	{
		this.sfAccount = sfAccount;
	}

	/// <summary>
	/// 指标项目名称。
	/// </summary>
	private String depProName;
	/**
	 * 项目库编码
	 */
	private String bgtProjCode;
	/**
	 * 项目库名称
	 */
	private String bgtProjName;

	/// <summary>
	/// 指标摘要。
	/// </summary>
	private String bgtRemark;

	/// <summary>
	/// 批复日期。
	/// </summary>
	private String sendDate;

	/// <summary>
	/// 批示领导。
	/// </summary>
	private String grantLeader;

	/// <summary>
	/// 部门预算项目。
	/// </summary>
	private int deppro;

	/// <summary>
	/// 转移支付项目。
	/// </summary>
	private int trapro;

	/// <summary>
	/// 执行标记。
	/// </summary>
	private int bdgAllow;

	/// <summary>
	/// 预算指标版本。
	/// </summary>
	private int bgtVersion;

	/// <summary>
	/// 计划生成方式。
	/// </summary>
	private int planGenType;

	/// <summary>
	/// 计划类型。
	/// </summary>
	private int planType;

	/// <summary>
	/// 支付方式。
	/// </summary>
	private int payType;

	/// <summary>
	/// 清算银行。
	/// </summary>
	private int clearBank;

	/// <summary>
	/// 结算方式。
	/// </summary>
	private int setMode;

	/// <summary>
	/// 拨款用途。
	/// </summary>
	private String payMemo;

	// private String payremark;// PAYREMARK

	private int payBank;

	/// <summary>
	/// 金额。
	/// </summary>
	private double amt;

	/// <summary>
	/// 是否参与合并。
	/// </summary>
	private int isMerge;

	/// <summary>
	/// 单据类型。
	/// </summary>
	private int vchTypeId;

	/// <summary>
	/// 单据号。
	/// </summary>
	private String billId;

	/// <summary>
	/// 单据内部号。
	/// </summary>
	private String billSeq;
	/**
	 * 内部顺序号
	 */
	private int billSno;

	public int getBillSno()
	{
		return billSno;
	}

	public void setBillSno(int billSno)
	{
		this.billSno = billSno;
	}

	/// <summary>
	/// 来源控制字段。
	/// </summary>
	private int fromCtrlId;

	/// <summary>
	/// 指标号。
	/// </summary>
	private int ccid;

	/// <summary>
	/// 单据编码。
	/// </summary>
	private String billCode;

	/// <summary>
	/// 核算专户
	/// </summary>
	private int sfAccount;

	/// <summary>
	/// 资金状态
	/// </summary>
	private int fundStatus;

	/// <summary>
	/// voucher生成对应的xml
	/// </summary>
	private String voucher_Xml;

	/// <summary>
	/// 预留9。
	/// </summary>
	private int e9;

	/// <summary>
	/// 预留8。
	/// </summary>
	private int e8;

	/// <summary>
	/// 预留7。
	/// </summary>
	private int e7;

	/// <summary>
	/// 预留6。
	/// </summary>
	private int e6;

	/// <summary>
	/// 预留5。
	/// </summary>
	private int e5;

	/// <summary>
	/// 预留4。
	/// </summary>
	private int e4;

	/// <summary>
	/// 预留3。
	/// </summary>
	private int e3;

	/// <summary>
	/// 预留2。
	/// </summary>
	private int e2;

	/// <summary>
	/// 预留1。
	/// </summary>
	private int e1;

	/// <summary>
	/// 预留0。
	/// </summary>
	private int e0;

	/// <summary>
	/// 数值预留1。
	/// </summary>
	private double n1;

	/// <summary>
	/// 数值预留2。
	/// </summary>
	private double n2;

	/// <summary>
	/// 数值预留3。
	/// </summary>
	private double n3;

	/// <summary>
	/// 数值预留4。
	/// </summary>
	private double n4;

	/// <summary>
	/// 数值预留5。
	/// </summary>
	private double n5;

	/// <summary>
	/// 字符预留1。
	/// </summary>
	private String s1;

	/// <summary>
	/// 字符预留2。
	/// </summary>
	private String s2;

	/// <summary>
	/// 字符预留3。
	/// </summary>
	private String s3;

	/// <summary>
	/// 字符预留4。
	/// </summary>
	private String s4;

	/// <summary>
	/// 字符预留5。
	/// </summary>
	private String s5;

	private String groupKey;

	/// <summary>
	/// 汇总金额
	/// </summary>
	private double billSumAmt;

	private String wfState;

	private List<VoucherDTO> details;

	public List<VoucherDTO> getDetails()
	{
		return details;
	}

	public void setDetails(List<VoucherDTO> detaiList)
	{
		this.details = detaiList;
	}

	/*public VoucherExDTO getVoucherExchangeTag()
	{
		return voucherExchangeTag;
	}

	public void setVoucherExchangeTag(VoucherExDTO voucherExchangeTag)
	{
		this.voucherExchangeTag = voucherExchangeTag;
	}

 
	private VoucherExAttach voucherExAttachTag;

	public VoucherExAttach getVoucherExAttachTag()
	{
		return voucherExAttachTag;
	}

	public void setVoucherExAttachTag(VoucherExAttach voucherExAttachTag)
	{
		this.voucherExAttachTag = voucherExAttachTag;
	}
	*/
	/**
	 * voucher生成对应的xml
	 * 
	 * @return
	 */
	public String getVoucher_Xml()
	{
		return voucher_Xml;
	}

	/**
	 * voucher生成对应的xml
	 * 
	 * @param voucher_Xml
	 */
	public void setVoucher_Xml(String voucher_Xml)
	{
		this.voucher_Xml = voucher_Xml;
	}

	public String getBillMemo()
	{
		return billMemo;
	}

	public void setBillMemo(String billMemo)
	{
		this.billMemo = billMemo;
	}

	public int getExpStr()
	{
		return expStr;
	}

	public void setExpStr(int expStr)
	{
		this.expStr = expStr;
	}

	public int getBgtDir()
	{
		return bgtDir;
	}

	public void setBgtDir(int bgtDir)
	{
		this.bgtDir = bgtDir;
	}

	public int getControlType()
	{
		return controlType;
	}

	public void setControlType(int controlType)
	{
		this.controlType = controlType;
	}

	public int getBillType()
	{
		return billType;
	}

	public void setBillType(int billType)
	{
		this.billType = billType;
	}

	public int getWfActionId()
	{
		return wfActionId;
	}

	public void setWfActionId(int wfActionId)
	{
		this.wfActionId = wfActionId;
	}

	public String getGlBusiDate()
	{
		return glBusiDate;
	}

	public void setGlBusiDate(String glBusiDate)
	{
		this.glBusiDate = glBusiDate;
	}

	public int getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(int voucherId)
	{
		this.voucherId = voucherId;
	}

	public int getAdmDiv()
	{
		return admDiv;
	}

	public void setAdmDiv(int admDiv)
	{
		this.admDiv = admDiv;
	}

	public int getBdgYear()
	{
		return bdgYear;
	}

	public void setBdgYear(int bdgYear)
	{
		this.bdgYear = bdgYear;
	}

	public int getPlanMonth()
	{
		return planMonth;
	}

	public void setPlanMonth(int planMonth)
	{
		this.planMonth = planMonth;
	}

	public int getDepDiv()
	{
		return depDiv;
	}

	public void setDepDiv(int depDiv)
	{
		this.depDiv = depDiv;
	}

	public int getBdgManageDiv()
	{
		return bdgManageDiv;
	}

	public void setBdgManageDiv(int bdgManageDiv)
	{
		this.bdgManageDiv = bdgManageDiv;
	}

	public int getFinadmLevel()
	{
		return finadmLevel;
	}

	public void setFinadmLevel(int finadmLevel)
	{
		this.finadmLevel = finadmLevel;
	}

	public int getSupDep()
	{
		return supDep;
	}

	public void setSupDep(int supDep)
	{
		this.supDep = supDep;
	}

	public int getAgency()
	{
		return agency;
	}

	public void setAgency(int agency)
	{
		this.agency = agency;
	}

	public int getFundType()
	{
		return fundType;
	}

	public void setFundType(int fundType)
	{
		this.fundType = fundType;
	}

	public int getExpType()
	{
		return expType;
	}

	public void setExpType(int expType)
	{
		this.expType = expType;
	}

	public int getExpFunc()
	{
		return expFunc;
	}

	public void setExpFunc(int expFunc)
	{
		this.expFunc = expFunc;
	}

	public int getExpEco()
	{
		return expEco;
	}

	public void setExpEco(int expEco)
	{
		this.expEco = expEco;
	}

	public int getExpFundType()
	{
		return expFundType;
	}

	public void setExpFundType(int expFundType)
	{
		this.expFundType = expFundType;
	}

	public int getBgtSource()
	{
		return bgtSource;
	}

	public void setBgtSource(int bgtSource)
	{
		this.bgtSource = bgtSource;
	}

	public int getIndSource()
	{
		return indSource;
	}

	public void setIndSource(int indSource)
	{
		this.indSource = indSource;
	}

	public int getIncomeType()
	{
		return incomeType;
	}

	public void setIncomeType(int inComeType)
	{
		this.incomeType = inComeType;
	}

	public int getIncomeSort()
	{
		return incomeSort;
	}

	public void setIncomeSort(int inComeSort)
	{
		this.incomeSort = inComeSort;
	}

	public int getAgencyInc()
	{
		return agencyInc;
	}

	public void setAgencyInc(int agencyInc)
	{
		this.agencyInc = agencyInc;
	}

	public int getVillagesInc()
	{
		return villagesInc;
	}

	public void setVillagesInc(int villagesInc)
	{
		this.villagesInc = villagesInc;
	}

	public int getSpecialAccType()
	{
		return specialAccType;
	}

	public void setSpecialAccType(int specialAccType)
	{
		this.specialAccType = specialAccType;
	}

	public int getSpecialAccInc()
	{
		return specialAccInc;
	}

	public void setSpecialAccInc(int specialAccInc)
	{
		this.specialAccInc = specialAccInc;
	}

	public String getBgtDocNo()
	{
		return bgtDocNo;
	}

	public void setBgtDocNo(String bgtDocNo)
	{
		this.bgtDocNo = bgtDocNo;
	}

	public String getBgtRemark()
	{
		return bgtRemark;
	}

	public void setBgtRemark(String bgtRemark)
	{
		this.bgtRemark = bgtRemark;
	}

	public String getSendDate()
	{
		return sendDate;
	}

	public void setSendDate(String sendDate)
	{
		this.sendDate = sendDate;
	}

	public String getGrantLeader()
	{
		return grantLeader;
	}

	public void setGrantLeader(String grantLeader)
	{
		this.grantLeader = grantLeader;
	}

	public int getDeppro()
	{
		return deppro;
	}

	public void setDeppro(int deppro)
	{
		this.deppro = deppro;
	}

	public int getTrapro()
	{
		return trapro;
	}

	public void setTrapro(int trapro)
	{
		this.trapro = trapro;
	}

	public int getBdgAllow()
	{
		return bdgAllow;
	}

	public void setBdgAllow(int bdgAllow)
	{
		this.bdgAllow = bdgAllow;
	}

	public int getBgtVersion()
	{
		return bgtVersion;
	}

	public void setBgtVersion(int bgtVersion)
	{
		this.bgtVersion = bgtVersion;
	}

	public int getPlanGenType()
	{
		return planGenType;
	}

	public void setPlanGenType(int planGenType)
	{
		this.planGenType = planGenType;
	}

	public int getPlanType()
	{
		return planType;
	}

	public void setPlanType(int planType)
	{
		this.planType = planType;
	}

	public int getPayType()
	{
		return payType;
	}

	public void setPayType(int payType)
	{
		this.payType = payType;
	}

	public int getClearBank()
	{
		return clearBank;
	}

	public void setClearBank(int clearBank)
	{
		this.clearBank = clearBank;
	}

	public int getPayBank()
	{
		return payBank;
	}

	public void setPayBank(int payBank)
	{
		this.payBank = payBank;
	}

	public int getSetMode()
	{
		return setMode;
	}

	public void setSetMode(int setMode)
	{
		this.setMode = setMode;
	}

	public String getPayMemo()
	{
		return payMemo;
	}

	public void setPayMemo(String paymemo)
	{
		this.payMemo = paymemo;
	}

	public double getAmt()
	{
		return amt;
	}

	public void setAmt(double amt)
	{
		this.amt = amt;
	}

	public int getIsMerge()
	{
		return isMerge;
	}

	public void setIsMerge(int isMerge)
	{
		this.isMerge = isMerge;
	}

	public int getVchTypeId()
	{
		return vchTypeId;
	}

	public void setVchTypeId(int vchTypeId)
	{
		this.vchTypeId = vchTypeId;
	}

	public String getBillId()
	{
		return billId;
	}

	public void setBillId(String billId)
	{
		this.billId = billId;
	}

	public String getBillSeq()
	{
		return billSeq;
	}

	public void setBillSeq(String billSeq)
	{
		this.billSeq = billSeq;
	}

	public int getFromCtrlId()
	{
		return fromCtrlId;
	}

	public void setFromCtrlId(int fromCtrlId)
	{
		this.fromCtrlId = fromCtrlId;
	}

	public String getBillCode()
	{
		return billCode;
	}

	public void setBillCode(String billCode)
	{
		this.billCode = billCode;
	}

	public int getFundStatus()
	{
		return fundStatus;
	}

	public void setFundStatus(int fundStatus)
	{
		this.fundStatus = fundStatus;
	}

	/*
	 * public int getGlbtdirect() { return glbtdirect; }
	 * 
	 * public void setGlbtdirect(int glbtdirect) { this.glbtdirect = glbtdirect;
	 * }
	 */
	public int getE9()
	{
		return e9;
	}

	public void setE9(int e9)
	{
		this.e9 = e9;
	}

	public int getE8()
	{
		return e8;
	}

	public void setE8(int e8)
	{
		this.e8 = e8;
	}

	public int getE7()
	{
		return e7;
	}

	public void setE7(int e7)
	{
		this.e7 = e7;
	}

	public int getE6()
	{
		return e6;
	}

	public void setE6(int e6)
	{
		this.e6 = e6;
	}

	public int getE5()
	{
		return e5;
	}

	public void setE5(int e5)
	{
		this.e5 = e5;
	}

	public int getE4()
	{
		return e4;
	}

	public void setE4(int e4)
	{
		this.e4 = e4;
	}

	public int getE3()
	{
		return e3;
	}

	public void setE3(int e3)
	{
		this.e3 = e3;
	}

	public int getE2()
	{
		return e2;
	}

	public void setE2(int e2)
	{
		this.e2 = e2;
	}

	public int getE1()
	{
		return e1;
	}

	public void setE1(int e1)
	{
		this.e1 = e1;
	}

	public int getE0()
	{
		return e0;
	}

	public void setE0(int e0)
	{
		this.e0 = e0;
	}

	public double getN1()
	{
		return n1;
	}

	public void setN1(double n1)
	{
		this.n1 = n1;
	}

	public double getN2()
	{
		return n2;
	}

	public void setN2(double n2)
	{
		this.n2 = n2;
	}

	public double getN3()
	{
		return n3;
	}

	public void setN3(double n3)
	{
		this.n3 = n3;
	}

	public double getN4()
	{
		return n4;
	}

	public void setN4(double n4)
	{
		this.n4 = n4;
	}

	public double getN5()
	{
		return n5;
	}

	public void setN5(double n5)
	{
		this.n5 = n5;
	}

	public String getS1()
	{
		return s1;
	}

	public void setS1(String s1)
	{
		this.s1 = s1;
	}

	public String getS2()
	{
		return s2;
	}

	public void setS2(String s2)
	{
		this.s2 = s2;
	}

	public String getS3()
	{
		return s3;
	}

	public void setS3(String s3)
	{
		this.s3 = s3;
	}

	public String getS4()
	{
		return s4;
	}

	public void setS4(String s4)
	{
		this.s4 = s4;
	}

	public String getS5()
	{
		return s5;
	}

	public void setS5(String s5)
	{
		this.s5 = s5;
	}

	// 2017.08.21增加
	// private String s0;
	private String s6;
	private String s7;
	private String s8;
	private String s9;
	// private double n0;
	private double n6;
	private double n7;
	private double n8;
	private double n9;

	// public String getS0() {
	// return s0;
	// }
	//
	// public void setS0(String s0) {
	// this.s0 = s0;
	// }

	public String getS6()
	{
		return s6;
	}

	public void setS6(String s6)
	{
		this.s6 = s6;
	}

	public String getS7()
	{
		return s7;
	}

	public void setS7(String s7)
	{
		this.s7 = s7;
	}

	public String getS8()
	{
		return s8;
	}

	public void setS8(String s8)
	{
		this.s8 = s8;
	}

	public String getS9()
	{
		return s9;
	}

	public void setS9(String s9)
	{
		this.s9 = s9;
	}

	// public double getN0() {
	// return n0;
	// }
	//
	// public void setN0(double n0) {
	// this.n0 = n0;
	// }

	public double getN6()
	{
		return n6;
	}

	public void setN6(double n6)
	{
		this.n6 = n6;
	}

	public double getN7()
	{
		return n7;
	}

	public void setN7(double n7)
	{
		this.n7 = n7;
	}

	public double getN8()
	{
		return n8;
	}

	public void setN8(double n8)
	{
		this.n8 = n8;
	}

	public double getN9()
	{
		return n9;
	}

	public void setN9(double n9)
	{
		this.n9 = n9;
	}

	public String getGroupKey()
	{
		return groupKey;
	}

	public void setGroupKey(String groupKey)
	{
		this.groupKey = groupKey;
	}

	public double getBillSumAmt()
	{
		return billSumAmt;
	}

	public void setBillSumAmt(double billSumAmt)
	{
		this.billSumAmt = billSumAmt;
	}

	public String getWfState()
	{
		return wfState;
	}

	public void setWfState(String wfState)
	{
		this.wfState = wfState;
	}

	private int depExpEco;

	/**
	 * 
	 * @return 部门预算经济分类。
	 */
	public int getDepExpEco()
	{
		return depExpEco;
	}

	/**
	 * 
	 * @param depExpEco
	 *            部门预算经济分类。
	 */
	public void setDepExpEco(int depExpEco)
	{
		this.depExpEco = depExpEco;
	}

	private int depExpEcoDetail;

	/**
	 * 
	 * @return 部门预算经济分类细目。
	 */
	public int getDepExpEcoDetail()
	{
		return depExpEcoDetail;
	}

	/**
	 * 
	 * @param depExpEcoDetail
	 *            部门预算经济分类细目。
	 */
	public void setDepExpEcoDetail(int depExpEcoDetail)
	{
		this.depExpEcoDetail = depExpEcoDetail;
	}

	@Override
	// public Object clone() throws CloneNotSupportedException {
	// return super.clone();
	// }
	public Object clone() throws CloneNotSupportedException
	{
		VoucherDTO obj = null;
		return (VoucherDTO) super.clone();
	}

}
