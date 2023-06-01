package com.ndgrouops.motez.config;

import com.ndgrouops.motez.model.Category;
import com.ndgrouops.motez.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class LoadCategoryInDb implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception{
        Category category1 = new Category("mike", "desc");
        Category category2 = new Category("mele", "desciption");

        List<Category>catlist = Arrays.asList(category1, category2);
        catlist = catlist.stream().collect(Collectors.toList());

        categoryRepository.saveAll(catlist);
    }

}
