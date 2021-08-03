create or replace
algorithm = UNDEFINED view `v_person_number_absences` as
select
    `p`.`saga` as `saga`,
    `p`.`username` as `username`,
    `p`.`name` as `name`,
    `p`.`lastname` as `lastname`,
    `p`.`email` as `email`,
    `p`.`center_id` as `center_id`,
    `p`.`businesscode` as `businesscode`,
    ((
    select
        count(1)
    from
        `absence_local` `a`
    where
        ((`a`.`saga` = `p`.`saga`)
        and (`a`.`year` = year(now())))) + (
    select
        count(1)
    from
        `absence_pon` `a`
    where
        ((`a`.`saga` = `p`.`saga`)
        and (`a`.`year` = year(now()))))) as `number_absences`
from
    `person` `p`
where
    (`p`.`active` = 1);


ALTER TABLE t_absence ADD `type` varchar(3) NULL;

ALTER TABLE absence_local ADD `type` varchar(3) NULL;

ALTER TABLE absence_pon ADD `type` varchar(3) NULL;


update absence_local set type = 'VAC';

update absence_pon set type = 'VAC';


create or replace
algorithm = UNDEFINED view `v_person_absence` as
select
    concat(`t`.`date`, '_', `t`.`type`, '_', `t`.`person_id`) as `id`,
    `t`.`person_id` as `person_id`,
    `t`.`year` as `year`,
    `t`.`month` as `month`,
    `t`.`date` as `date`,
    `t`.`type` as `type`,
    t.absence_type as absence_type
from
    (
    select
        `p`.`id` as `person_id`,
        `f`.`date` as `date`,
        `f`.`year` as `year`,
        `f`.`month` as `month`,
        'F' as `type`,
        null as absence_type
    from
        (`team_management`.`person` `p`
    join `team_management`.`festive` `f` on
        ((`p`.`center_id` = `f`.`center_id`)))
union all
    select
        `p`.`id` as `person_id`,
        `a`.`date` as `date`,
        `a`.`year` as `year`,
        `a`.`month` as `month`,
        'P' as `type`,
        a.type as absence_type
    from
        (`team_management`.`person` `p`
    join `team_management`.`absence_pon` `a` on
        ((`a`.`saga` = `p`.`saga`)))
union all
    select
        `p`.`id` as `person_id`,
        `a`.`date` as `date`,
        `a`.`year` as `year`,
        `a`.`month` as `month`,
        'A' as `type`,
        a.type as absence_type
    from
        (`team_management`.`person` `p`
    join `team_management`.`absence_local` `a` on
        ((`a`.`saga` = `p`.`saga`)))) `t`;



