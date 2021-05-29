SET FOREIGN_KEY_CHECKS=0;
truncate table author;
truncate table author_posts;
truncate table comment;
truncate table post;
truncate table post_comments;

INSERT INTO post(id, title, post_content)
VALUES (10, 'first title', 'content 1'),
        (11, 'second title', 'content 2'),
     (12, 'third title', 'content 3'),
     (13, 'fourth title', 'content 4');

SET FOREIGN_KEY_CHECKS=1