package com.neodev.cupgift.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.neodev.cupgift.model.Theme;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface ThemeRepository extends JpaRepository<Theme,Long> {
    @Modifying 
    @Transactional  
    @Query(value = "delete from theme where theme_id=?1",nativeQuery=true)  
    public void deleteByThemeId(Long themeId);

    @Modifying 
    @Transactional  
    @Query(value = "Update theme set theme_name=?2,theme_details=?3,theme_price=?4 where theme_id=?1",nativeQuery=true)  
    public void editByThemeId(Long themeId,String themeName,String themeDetails,int themePrice);
}
