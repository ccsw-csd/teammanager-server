ALTER TABLE team_management.`group` ADD public BIT DEFAULT 0 NULL;

create or replace view public_group as 
select concat(group_id, '-MEM-', vgma.person_id) as id, group_id, vgma.person_id, p.username from `group` g join v_group_members_all vgma on vgma.group_id = g.id join person p on vgma.person_id = p.id
where g.public = 1	
union
select concat(group_id, '-MAN-', gm.person_id) as id, group_id, gm.person_id, p.username from `group` g join group_manager gm on gm.group_id = g.id join person p on gm.person_id = p.id
where g.public = 1;


