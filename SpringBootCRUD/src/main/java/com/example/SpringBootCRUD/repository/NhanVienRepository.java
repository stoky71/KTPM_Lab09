package com.example.SpringBootCRUD.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCRUD.entity.NhanVien;


@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String>{
	@Query(value = "select * from nhanvien where Luong < 10000", nativeQuery = true)
	public List<NhanVien> findNhanVienLuongItHon10k();
	
	@Query(value = "select sum(Luong) from nhanvien", nativeQuery = true)
	public Long tongSoLuongPhaiTraChoNhanVien();
	
	@Query(value = " select * from nhanvien n join chungnhan c \n" +
            "on n.MaNV = c.MaNV join maybay m on m.MaMB = c.MaMB\n" +
            "where m.Loai like '%Boeing%'\n" +
            "group by n.MaNV, n.Ten  ", nativeQuery = true)
	public List<NhanVien> findPhiCongDriveBoeing();
	
	@Query(value = "select * from nhanvien where MaNV=?1 ", nativeQuery = true)
    public NhanVien findNhanVienByMaNV(String MaNV);

    @Query(value = "select * from nhanvien ", nativeQuery = true)
    public List<NhanVien> findAllNhanVien();
    
    @Transactional
    @Modifying
    @Query(value = "update nhanvien set Luong=?2 where MaNV=?1 ", nativeQuery = true)
    public void updateNhanVienById(String maNV, Integer luong);

    @Transactional
    @Modifying
    @Query(value = "delete from nhanvien where MaNV=?1", nativeQuery = true)
    public void deleteNhanVienById(String maNV);
}
