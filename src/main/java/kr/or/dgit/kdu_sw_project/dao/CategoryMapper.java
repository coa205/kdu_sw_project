package kr.or.dgit.kdu_sw_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.kdu_sw_project.dto.Category;

public interface CategoryMapper {
	List<Category> selectAllCategory();
	Category selectByNoCategory(Category category);
	int insertRowCategory(Category category);
	int updateRowCategory(Map<String, String> category);
	int deleteRowCategory(Category Category);
}
