package com.iib.main.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iib.main.entity.File;
import com.iib.main.entity.IibappUploadfile;

@Repository
public interface FileRepository extends CrudRepository<IibappUploadfile,Integer>{
	
	@Query(value = "select file_status from iibapp_uploadedfile where file_name=:filename",nativeQuery = true)
	public List<String> getstatus(String filename);
	
	@Query(value = "select failure_records from iibapp_uploadedfile where file_name=:filename and file_status=:status",nativeQuery = true)
	public String getFailurecount(String filename, String status);
	
	
	@Query(value="select top 1 file_name from iibapp_uploadedfile where insurer_id=:insurerid and  year=:year and file_type=:filetype  order by uploaded_on desc",nativeQuery = true)
	public String getFilename(int insurerid,String year, String filetype);
	
}
