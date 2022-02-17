BEGIN;


CREATE TABLE public.cities
(
    city_id integer NOT NULL,
    city_name character varying(20) NOT NULL,
    PRIMARY KEY (city_id)
);

CREATE TABLE public.confirmation_by_employees
(
    confirm_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    verified_status boolean NOT NULL,
    employee_id integer NOT NULL,
    approval_date date NOT NULL,
    PRIMARY KEY (confirm_id)
);

CREATE TABLE public.confirming_employers
(
    confirm_id integer NOT NULL,
    employer_id integer NOT NULL
);

CREATE TABLE public.confirming_jobadvertisements
(
    confirm_id integer NOT NULL,
    advert_id integer NOT NULL,
    PRIMARY KEY (confirm_id)
);

CREATE TABLE public.confirming_updates
(
    confirm_id integer NOT NULL,
    employer_id integer NOT NULL,
    update_id integer NOT NULL,
    PRIMARY KEY (confirm_id)
);

CREATE TABLE public.cover_letters
(
    letter_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    letter_content character varying(400) NOT NULL,
    PRIMARY KEY (letter_id)
);

CREATE TABLE public.educations
(
    education_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    school_name character varying(255) NOT NULL,
    department character varying(255) NOT NULL,
    start_date date NOT NULL,
    graduated_date date,
    PRIMARY KEY (education_id)
);

CREATE TABLE public.employees
(
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    position_id integer,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employer_updates
(
    update_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    employee_id integer,
    phone_number character(10) NOT NULL,
    email character varying(255) NOT NULL,
    company_name character varying(255) NOT NULL,
    web_site character varying(255) NOT NULL,
    approve_status boolean NOT NULL,
    approve_date date NOT NULL,
    PRIMARY KEY (update_id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(100) NOT NULL,
    web_site character varying(50) NOT NULL,
    employer_is_confirmed boolean NOT NULL,
    waiting_for_update boolean NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employment_times
(
    time_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    time_name character varying(255) NOT NULL,
    PRIMARY KEY (time_id)
);

CREATE TABLE public.employment_types
(
    type_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    type_name character varying(255) NOT NULL,
    PRIMARY KEY (type_id)
);

CREATE TABLE public.job_advert_favorites
(
    favorite_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    advert_id integer NOT NULL,
    PRIMARY KEY (favorite_id)
);

CREATE TABLE public.job_advertisements
(
    advert_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    min_salary integer NOT NULL,
    max_salary integer NOT NULL,
    quota integer NOT NULL,
    last_application character varying(20) NOT NULL,
    created_date date NOT NULL,
    advert_status boolean NOT NULL,
    position_id integer NOT NULL,
    job_description character varying(500) NOT NULL,
    city_id integer NOT NULL,
    type_id integer NOT NULL,
    time_id integer NOT NULL,
    advert_is_confirmed boolean,
    PRIMARY KEY (advert_id)
);

CREATE TABLE public.job_experiences
(
    experience_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    workplace_name character varying(255) NOT NULL,
    position_name character varying(255) NOT NULL,
    start_date date NOT NULL,
    leave_date date,
    PRIMARY KEY (experience_id)
);

CREATE TABLE public.languages
(
    language_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    language_name character varying(255) NOT NULL,
    language_level integer NOT NULL,
    PRIMARY KEY (language_id)
);

CREATE TABLE public.links
(
    link_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    github_link character varying(300) NOT NULL,
    linkedin_link character varying(300) NOT NULL,
    PRIMARY KEY (link_id)
);

CREATE TABLE public.photos
(
    photo_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    photo_url character varying(255) NOT NULL,
    upload_date date NOT NULL,
    PRIMARY KEY (photo_id)
);

CREATE TABLE public.positions
(
    position_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    position_name character varying(30) NOT NULL,
    PRIMARY KEY (position_id)
);

CREATE TABLE public.technologies
(
    technology_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    unemployed_id integer NOT NULL,
    technology_name character varying(255) NOT NULL,
    technology_level integer NOT NULL,
    PRIMARY KEY (technology_id)
);

CREATE TABLE public.unemployeds
(
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    nationality_id character(11) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.users
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    phone_number character(10) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(25) NOT NULL,
    mail_is_verify boolean NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.verifications
(
    verification_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    is_verified boolean,
    verification_code character varying(255) NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (verification_id)
);

ALTER TABLE public.confirmation_by_employees
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (user_id)
    NOT VALID;


ALTER TABLE public.confirming_employers
    ADD FOREIGN KEY (confirm_id)
    REFERENCES public.confirmation_by_employees (confirm_id)
    NOT VALID;


ALTER TABLE public.confirming_employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.confirming_jobadvertisements
    ADD FOREIGN KEY (confirm_id)
    REFERENCES public.confirmation_by_employees (confirm_id)
    NOT VALID;


ALTER TABLE public.confirming_jobadvertisements
    ADD FOREIGN KEY (advert_id)
    REFERENCES public.job_advertisements (advert_id)
    NOT VALID;


ALTER TABLE public.confirming_updates
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.confirming_updates
    ADD FOREIGN KEY (confirm_id)
    REFERENCES public.confirmation_by_employees (confirm_id)
    NOT VALID;


ALTER TABLE public.confirming_updates
    ADD FOREIGN KEY (update_id)
    REFERENCES public.employer_updates (update_id)
    NOT VALID;


ALTER TABLE public.cover_letters
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.educations
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (position_id)
    REFERENCES public.positions (position_id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.employer_updates
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (user_id)
    NOT VALID;


ALTER TABLE public.employer_updates
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.job_advert_favorites
    ADD FOREIGN KEY (advert_id)
    REFERENCES public.job_advertisements (advert_id)
    NOT VALID;


ALTER TABLE public.job_advert_favorites
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (city_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (position_id)
    REFERENCES public.positions (position_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (time_id)
    REFERENCES public.employment_times (time_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (type_id)
    REFERENCES public.employment_types (type_id)
    NOT VALID;


ALTER TABLE public.job_experiences
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.languages
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.links
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.photos
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.technologies
    ADD FOREIGN KEY (unemployed_id)
    REFERENCES public.unemployeds (user_id)
    NOT VALID;


ALTER TABLE public.unemployeds
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.verifications
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;

END;