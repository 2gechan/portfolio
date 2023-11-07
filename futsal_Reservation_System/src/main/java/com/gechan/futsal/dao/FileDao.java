package com.gechan.futsal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gechan.futsal.models.FileDto;

public interface FileDao {
	
	
	public int insert(@Param("list") List<FileDto> files, @Param("f_cnumber") long f_cnumber);
	public List<FileDto> selectAll();
	
	@Select("select * from tbl_images where i_seq = #{id}")
	public FileDto findById(long id);
	
	// 게시판과 연결할 때 사용할 method
	@Select("select * from tbl_images where i_fcnumber = #{i_fcnumber}")
	public List<FileDto> findByBSeq(long i_fcnumber);
	
	@Delete("delete from tbl_images where i_seq = #{seqNum}")
	public int delete(long seqNum);

}
