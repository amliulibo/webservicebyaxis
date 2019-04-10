public class ${shortname}BOImpl implements I${shortname}BO {

	private  I${shortname}DAO ${shortname}DAO; 
	
	public I${shortname}DAO get${shortname?cap_first}DAO() {
		return ${shortname}DAO;
	}

	public void set${shortname?cap_first}DAO(I${shortname}DAO ${shortname}DAO) {
		this.${shortname}DAO = ${shortname}DAO;
	}
	
	public boolean saveOne(DBManager dbManager, ${shortname}DTO dto)
	{
		dto.setBillId( get${shortname?cap_first}DAO().selectSNO());
		//dto.setBillCreateUser(dto.getBillLastUser());
        // dto.setBillCreateDate(dto.getBillLastDate());
         for (int i = 0; i < dto.getDetails().size(); i++)
         {
             dto.getDetails().get(i).setBillSeq(get${shortname?cap_first}DAO().selectGUID());
             dto.getDetails().get(i).setVoucherId(dto.getVoucherId());
             dto.getDetails().get(i).setBillId(dto.getBillId());
             dto.getDetails().get(i).setBillCreateUser(dto.getBillCreateUser());
             dto.getDetails().get(i).setBillCreateDate(dto.getBillCreateDate());
             dto.getDetails().get(i).setBillCode(dto.getBillCode());
             dto.getDetails().get(i).setBillSno(i);
             
             int rowCnt = this.get${shortname?cap_first}DAO().insertOne( dbManager, (ApplyVoucherDTO)dto.getDetails().get(i) );
            
         }
	}

	
	 
	public boolean updateOne(DBManager dbManager, ${shortname}DTO dto);
	
	
	public List<${shortname}DTO> getList(DBManager dbManager, ${shortname}DTO dto);

	
	 

}