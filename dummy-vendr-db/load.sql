\COPY users(id, first_name, last_name, gender, min_age, max_age, likes, dislikes) FROM 'data/users.dat' WITH DELIMITER ',' NULL '' CSV
\COPY userstat(user_id, level, points, likes, dislikes) FROM 'userstat/Beer.dat' WITH DELIMITER ',' NULL '' CSV
\COPY ad(id, price_in_cents, category) FROM 'data/ad.dat' WITH DELIMITER ',' NULL '' CSV
\COPY user_like_ad(user_id, ad_id, did_like, time_of_like) FROM 'data/user_like_ad.dat' WITH DELIMITER ',' NULL '' CSV
