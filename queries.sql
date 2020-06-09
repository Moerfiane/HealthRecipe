--## Part 1: Create static dietary_restrictions_search static table
CREATE TABLE dietary_restrictions_search (
  restrict_id INT NOT NULL,
  health_conds varchar(255),
  restrictions varchar(255),
  PRIMARY KEY (restrict_id)
  );

   INSERT INTO dietary_restrictions_search (restrict_id, health_conds)
	VALUES 	(101,"Celiac Disease"),
			(102,"Diabetes"),
			(103,"High Blood Pressure");

  INSERT INTO dietary_restrictions_search (restrict_id, restrictions)
	VALUES 	(301,"No Carbohydrates"),
			(302,"No Dairy"),
			(303,"No Saturated Fats"),
			(304,"No Sodium"),
			(305,"Gluten Free"),
			(306,"Nitrate Free"),
			(307,"Sodium Free");


--## Part 2: Test it with SQL
SELECT name from employer
WHERE location = 'St. Louis, MO';

--## Part 3: Test it with SQL
DROP TABLE job;

--## Part 4: Test it with SQL
SELECT name, description FROM health_recipe.skill WHERE id in(SELECT skills_id FROM job_skills WHERE skills_id IS NOT NULL);