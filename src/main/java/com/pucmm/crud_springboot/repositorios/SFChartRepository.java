package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.SFChart;
import com.pucmm.crud_springboot.entidades.SubFamiliaEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SFChartRepository extends JpaRepository<SFChart,Long> {
}
