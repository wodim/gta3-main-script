MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Cat mission 1*****************************************
// *************************************FINAL MISSION*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_cat1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_cat1_failed
ENDIF

GOSUB mission_cleanup_cat1			  

MISSION_END

// Variables for mission

VAR_INT blip1_cat1 marias_blip 
VAR_INT	colubian_guard1 colubian_guard2 colubian_guard3 colubian_guard4 colubian_guard5 colubian_guard6 colubian_guard7 colubian_guard8 
VAR_INT	colubian_guard9 colubian_guard10 colubian_guard11 colubian_guard12 colubian_guard13 colubian_guard14 colubian_guard15 colubian_guard16
VAR_INT colubian_guard17 colubian_guard18 colubian_guard19 colubian_guard20 colubian_guard21 colubian_guard22 colubian_guard23 colubian_guard24  
VAR_INT colubian_guard25 colubian_guard26
VAR_INT colubian_car1 colubian_car2 colubian_car3 colubian_car4 colubian_car5 colubian_car6 colubian_car7 colubian_car8
VAR_INT escape_chopper set_as_leader_before	been_on_heli_pad Dead_guards_gun
VAR_INT countdown_cat1 rocket_launch added_the_blip_for_maria maria_created_before
VAR_INT camera_cut first_credits_loop
VAR_INT shaggin_waggin maria_prossie
VAR_FLOAT playerx_cat playery_cat playerz_cat

// ***************************************Mission Start*************************************

mission_start_cat1:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_cat_mission = 1
SCRIPT_NAME cat1
WAIT 0

added_the_blip_for_maria = 0
been_on_heli_pad = 0
set_as_leader_before = 0
maria_created_before = 0
flag_player_on_mission = 1
camera_cut = 0

SETUP_ZONE_PED_INFO WEE_DAM DAY   (0) 0 0 0 0 0 0 0 0  
SETUP_ZONE_PED_INFO WEE_DAM NIGHT (0) 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO WEE_DAM DAY   (0) 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO WEE_DAM NIGHT (0) 0 0 0 0 0 0 0 0 0 0 0 0 0	0


{
CLEAR_WANTED_LEVEL player


LOAD_SPECIAL_CHARACTER 1 Maria
LOAD_SPECIAL_CHARACTER 2 cat
LOAD_SPECIAL_CHARACTER 3 col2
LOAD_SPECIAL_CHARACTER 4 colrob
LOAD_SPECIAL_MODEL cut_obj1	fulcase
LOAD_SPECIAL_MODEL cut_obj2	cath
REQUEST_MODEL PED_GANG_COLOMBIAN_A
REQUEST_MODEL PED_GANG_COLOMBIAN_B
REQUEST_MODEL CAR_COLUMB
REQUEST_MODEL CAR_FLATBED
REQUEST_MODEL New_Colmansn
REQUEST_MODEL landpart15
REQUEST_MODEL Security_Hut 
REQUEST_MODEL columansion_wall

LOAD_ALL_MODELS_NOW

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	OR NOT HAS_MODEL_LOADED cut_obj1
	OR NOT HAS_MODEL_LOADED cut_obj2
		WAIT 0
	ENDWHILE

	WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A 
	OR NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_B
		WAIT 0
	ENDWHILE

	WHILE NOT HAS_MODEL_LOADED CAR_COLUMB
	OR NOT HAS_MODEL_LOADED	New_Colmansn
	OR NOT HAS_MODEL_LOADED	landpart15
	OR NOT HAS_MODEL_LOADED Security_Hut
	OR NOT HAS_MODEL_LOADED columansion_wall
		WAIT 0

	ENDWHILE

LOAD_SCENE -363.5 243.5 59.3

LOAD_CUTSCENE C1_TEX
SET_CUTSCENE_OFFSET -358.553 249.189 59.329 

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_cat
SET_CUTSCENE_ANIM cs_cat cat

//CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_colub1
//SET_CUTSCENE_ANIM cs_colub1 col2 //(unarmed) 

CREATE_CUTSCENE_OBJECT PED_SPECIAL4 cs_colub2
SET_CUTSCENE_ANIM cs_colub2 colrob //(Pistol)  

CREATE_CUTSCENE_OBJECT PED_GANG_COLOMBIAN_A cs_colub3
SET_CUTSCENE_ANIM cs_colub3 gang11 //(unarmed)

CREATE_CUTSCENE_OBJECT PED_GANG_COLOMBIAN_B cs_colub4
SET_CUTSCENE_ANIM cs_colub4 gang12 //(unarmed) 

CREATE_CUTSCENE_OBJECT cut_obj1 cs_case
SET_CUTSCENE_ANIM cs_case fulcase 

CREATE_CUTSCENE_HEAD cs_cat cut_obj2 cs_cathead
SET_CUTSCENE_HEAD_ANIM cs_cathead cat

CREATE_CAR CAR_COLUMB -422.9 291.8 61.8 colubian_car1
SET_CAR_HEADING colubian_car1 226.0

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -395.4 293.4 -100.0 colubian_guard1	//Near Cat
GIVE_WEAPON_TO_CHAR colubian_guard1 WEAPONTYPE_UZI 200
//ADD_ARMOUR_TO_CHAR colubian_guard1 100

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -368.1 252.4 -100.0 colubian_guard3	//Guarding gate (west)
GIVE_WEAPON_TO_CHAR colubian_guard3 WEAPONTYPE_UZI 200
SET_CHAR_HEADING colubian_guard3 0.0

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -358.0 251.8 -100.0 colubian_guard4	//Guarding gate	(east)
GIVE_WEAPON_TO_CHAR colubian_guard4 WEAPONTYPE_UZI 200
SET_CHAR_HEADING colubian_guard4 0.0

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -392.4 301.0 70.7 colubian_guard12 //On masion balcony (west)
GIVE_WEAPON_TO_CHAR colubian_guard12 WEAPONTYPE_CHAINGUN 200
SET_CHAR_HEADING colubian_guard12 0.0
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard12 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -374.0 301.0 70.7 colubian_guard13 //On masion balcony (east)
GIVE_WEAPON_TO_CHAR colubian_guard13 WEAPONTYPE_CHAINGUN 200
SET_CHAR_HEADING colubian_guard13 0.0
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard13 TRUE

SET_EVERYONE_IGNORE_PLAYER Player ON

TURN_CHAR_TO_FACE_PLAYER colubian_guard1 Player
TURN_CHAR_TO_FACE_PLAYER colubian_guard12 Player
TURN_CHAR_TO_FACE_PLAYER colubian_guard13 Player
CLEAR_AREA -362.8 246.5 60.0 4.5 TRUE


CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -380.1 282.6 -100.0 colubian_guard2	 //Dead guard
SET_CHAR_HEADING colubian_guard2 229.0
SET_CHAR_HEALTH	colubian_guard2 0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON			 
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 22000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_PLAYER_COORDINATES player -363.3 253.0 -100.0
//PRINT_NOW ( CAT2_A1 ) 3000 2 // Mission brief

WHILE cs_time < 32166
	WAIT 0		
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_A ) 10000 2 // Mission brief

WHILE cs_time < 38548
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_B ) 10000 2 // Mission brief

WHILE cs_time < 40043
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_B2 ) 10000 2 // Mission brief

WHILE cs_time < 43684
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_C ) 10000 2 // Mission brief

WHILE cs_time < 45711
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_D ) 10000 2 // Mission brief

WHILE cs_time < 52048
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_E ) 10000 2 // Mission brief

WHILE cs_time < 54527
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_E2 ) 10000 2 // Mission brief

WHILE cs_time < 57558
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CAT2_E3 ) 10000 2 // Mission brief

WHILE cs_time < 58661
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS 

WHILE cs_time < 65000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//DO_FADE 1500 FADE_OUT

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

CLEAR_PRINTS

CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ONCE 48 -380.1 282.6 62.6 Dead_guards_gun
CLEAR_AREA -381.8 284.0 62.9 1.0 TRUE
SET_PLAYER_COORDINATES player -381.8 284.0 -100.0
SET_PLAYER_HEADING player 232.0

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_EVERYONE_IGNORE_PLAYER Player ON
SET_CAMERA_BEHIND_PLAYER


REMOVE_ALL_PLAYER_WEAPONS Player

//WAIT 500

//DO_FADE 1500 FADE_IN

IF nicked_half_a_mil_before = 0
	ADD_SCORE player -500000
	nicked_half_a_mil_before = 1
ENDIF

UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED New_Colmansn
MARK_MODEL_AS_NO_LONGER_NEEDED landpart15
MARK_MODEL_AS_NO_LONGER_NEEDED Security_Hut
MARK_MODEL_AS_NO_LONGER_NEEDED columansion_wall

	WHILE NOT HAS_MODEL_LOADED CAR_FLATBED
		WAIT 0

	ENDWHILE

PRINT_NOW ( CATINF1 ) 5000 2 // Mission brief

WAIT 1000


SET_EVERYONE_IGNORE_PLAYER Player OFF
//GOTO last_cutscene //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//flag_cat_mission1_passed = 1
//START_NEW_SCRIPT credits_loop
//GOSUB credits


countdown_cat1 = 421000
DISPLAY_ONSCREEN_TIMER countdown_cat1


IF NOT IS_CHAR_DEAD colubian_guard1
AND NOT IS_CHAR_DEAD colubian_guard2
AND NOT IS_CHAR_DEAD colubian_guard12
AND NOT IS_CHAR_DEAD colubian_guard13
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard1 Player
	SET_CHAR_THREAT_SEARCH colubian_guard1 THREAT_PLAYER1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard2 Player
	SET_CHAR_THREAT_SEARCH colubian_guard2 THREAT_PLAYER1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard12	Player
	SET_CHAR_THREAT_SEARCH colubian_guard12 THREAT_PLAYER1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard13	Player
	SET_CHAR_THREAT_SEARCH colubian_guard13 THREAT_PLAYER1
ENDIF

IF NOT IS_CHAR_DEAD colubian_guard3
AND NOT IS_CHAR_DEAD colubian_guard4
	SET_CHAR_THREAT_SEARCH colubian_guard3 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH colubian_guard4 THREAT_PLAYER1
ENDIF

SWITCH_PED_ROADS_OFF -942.6 337.0 10.0 -953.6 361.4 30.0 // DAM

WHILE IS_PLAYER_IN_AREA_3D player -448.0 241.7 50.0 -292.4 365.2 90.0 FALSE
	WAIT 0

	IF countdown_cat1 = 0
		GOTO mission_cat1_failed
	ENDIF

	CLEAR_WANTED_LEVEL player
	
ENDWHILE

START_CATALINA_HELI							  

escape_chopper = -1

WHILE escape_chopper = -1
	WAIT 0
		GRAB_CATALINA_HELI escape_chopper
ENDWHILE

WAIT 1000

IF NOT IS_CAR_DEAD escape_chopper 
	ADD_BLIP_FOR_CAR escape_chopper blip1_cat1
	CHANGE_BLIP_DISPLAY blip1_cat1 BLIP_ONLY
	SET_FIXED_CAMERA_POSITION -364.5 243.7 62.7 0.0 0.0 0.0
	POINT_CAMERA_AT_CAR escape_chopper FIXED INTERPOLATION
	SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL Player Off
	SET_POLICE_IGNORE_PLAYER Player ON
	SET_EVERYONE_IGNORE_PLAYER Player ON
	SET_CAR_PROOFS escape_chopper TRUE TRUE TRUE TRUE TRUE
ENDIF

IF IS_PLAYER_IN_ANY_CAR Player
	APPLY_BRAKES_TO_PLAYERS_CAR Player ON
ENDIF


WAIT 5000

RESTORE_CAMERA
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL Player ON
APPLY_BRAKES_TO_PLAYERS_CAR Player OFF
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF

IF IS_PLAYER_IN_ANY_CAR Player
	APPLY_BRAKES_TO_PLAYERS_CAR Player OFF
ENDIF

PRINT_NOW ( CATINF2 ) 5000 2 // Mission brief

	WHILE NOT IS_PLAYER_IN_ZONE player BIG_DAM
		WAIT 0

		IF countdown_cat1 = 0
			PRINT_NOW ( OUTTIME ) 5000 1
			GOTO mission_cat1_failed
		ENDIF

		IF HAS_CATALINA_HELI_BEEN_SHOT_DOWN
			GOTO end_of_game
		ENDIF

		CLEAR_WANTED_LEVEL player

	ENDWHILE


SET_THREAT_FOR_PED_TYPE	PEDTYPE_GANG_COLOMBIAN THREAT_PLAYER1
SET_GANG_WEAPONS GANG_COLOMBIAN WEAPONTYPE_UZI WEAPONTYPE_CHAINGUN //The COLUMBIANS

MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard1
MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard2
MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard3
MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard4

CREATE_CAR CAR_COLUMB -946.8 310.0 -100.0 colubian_car6
SET_CAR_HEADING colubian_car6 104.7

CREATE_CAR CAR_COLUMB -952.3 310.3 -100.0 colubian_car7
SET_CAR_HEADING colubian_car7 78.8

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -955.5 309.7 -100.0 colubian_guard14 //guards by 1st columbian block
SET_CHAR_HEADING colubian_guard14 220.0
SET_CHAR_THREAT_SEARCH colubian_guard14 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard14 100
GIVE_WEAPON_TO_CHAR colubian_guard14 WEAPONTYPE_CHAINGUN 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -943.0 311.0 -100.0 colubian_guard15 //guards by 1st columbian block
SET_CHAR_HEADING colubian_guard15 176.0
//ADD_ARMOUR_TO_CHAR colubian_guard15 100
SET_CHAR_THREAT_SEARCH colubian_guard15 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard15 WEAPONTYPE_CHAINGUN 500

CREATE_CAR CAR_COLUMB -1035.7 464.1 -100.0 colubian_car2
SET_CAR_HEADING colubian_car2 194.0

CREATE_CAR CAR_COLUMB -1033.8 458.9 -100.0 colubian_car3
SET_CAR_HEADING colubian_car3 330.8


CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ONCE 3 -1149.7 347.7 30.4 rocket_launch

	WHILE NOT IS_PLAYER_IN_ZONE player WEE_DAM
		WAIT 0

		IF countdown_cat1 = 0
			PRINT_NOW ( OUTTIME ) 5000 1
			GOTO mission_cat1_failed
		ENDIF

		IF HAS_CATALINA_HELI_BEEN_SHOT_DOWN
			GOTO end_of_game
		ENDIF

		CLEAR_WANTED_LEVEL player

	ENDWHILE

SET_POLICE_IGNORE_PLAYER Player ON


//SET_GANG_PLAYER_ATTITUDE GANG_COLOMBIAN HATES player //The COLUMBIANS

//SWITCH_PED_ROADS_ON -952.5 361.4 10.0 -939.3 374.0 30.0 // DAM
/*
SETUP_ZONE_PED_INFO WEE_DAM DAY   (15) 0 0 0 0 0 1000 0 0  
SETUP_ZONE_PED_INFO WEE_DAM NIGHT (15) 0 0 0 0 0 1000 0 0
SETUP_ZONE_CAR_INFO WEE_DAM DAY   (0) 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO WEE_DAM NIGHT (0) 0 0 0 0 0 0 0 0 0 0 0 0 0	0
*/

	WHILE NOT IS_PLAYER_IN_AREA_3D player -927.4 391.5 50.0 -1124.3 485.1 0.0 FALSE
		WAIT 0							  

		IF countdown_cat1 = 0
			GOTO mission_cat1_failed
		ENDIF

		IF HAS_CATALINA_HELI_BEEN_SHOT_DOWN
			GOTO end_of_game
		ENDIF

		CLEAR_WANTED_LEVEL player
		
	ENDWHILE

MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard14
MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard15
MARK_CAR_AS_NO_LONGER_NEEDED colubian_car6
MARK_CAR_AS_NO_LONGER_NEEDED colubian_car7

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1037.2 467.9 -100.0 colubian_guard5 //guards by 2nd columbian block
SET_CHAR_HEADING colubian_guard5 272.0
SET_CHAR_THREAT_SEARCH colubian_guard5 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard5 100
GIVE_WEAPON_TO_CHAR colubian_guard5 WEAPONTYPE_M16 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1035.0 454.8 -100.0 colubian_guard6 //guards by 2nd columbian block
SET_CHAR_HEADING colubian_guard6 247.0
//ADD_ARMOUR_TO_CHAR colubian_guard6 100
SET_CHAR_THREAT_SEARCH colubian_guard6 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard6 WEAPONTYPE_M16 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1087.8 472.0 -100.0 colubian_guard7 //Fist guard on tower
SET_CHAR_HEADING colubian_guard7 237.0
//ADD_ARMOUR_TO_CHAR colubian_guard7 100
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard7 TRUE
SET_CHAR_THREAT_SEARCH colubian_guard7 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard7 WEAPONTYPE_M16 500
SET_CHAR_ACCURACY colubian_guard7 40

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1142.3 445.3 -100.0 colubian_guard8 //Fist guard on second tower
SET_CHAR_HEADING colubian_guard8 287.0
//ADD_ARMOUR_TO_CHAR colubian_guard8 100
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard8 TRUE
SET_CHAR_THREAT_SEARCH colubian_guard8 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard8 WEAPONTYPE_M16 500
SET_CHAR_ACCURACY colubian_guard8 40

CREATE_CAR CAR_FLATBED -1086.1 464.4 -100.0 colubian_car4
SET_CAR_HEADING colubian_car4 215.0

CREATE_CAR CAR_FLATBED -1174.8 406.9 -100.0 colubian_car5
SET_CAR_HEADING colubian_car5 322.0

CREATE_CAR CAR_FLATBED -1164.2 393.7 -100.0 colubian_car8
SET_CAR_HEADING colubian_car8 23.8

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1065.3 453.8 -100.0 colubian_guard16 //guards by 2nd columbian block
SET_CHAR_HEADING colubian_guard16 289.0
SET_CHAR_THREAT_SEARCH colubian_guard16 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard16 100
GIVE_WEAPON_TO_CHAR colubian_guard16 WEAPONTYPE_CHAINGUN 500
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard16 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1066.3 475.8 -100.0 colubian_guard17 //guards by 2nd columbian block
SET_CHAR_HEADING colubian_guard17 224.0
//ADD_ARMOUR_TO_CHAR colubian_guard17 100
SET_CHAR_THREAT_SEARCH colubian_guard17 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard17 WEAPONTYPE_CHAINGUN 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1104.9 440.1 -100.0 colubian_guard18 //On boxes
SET_CHAR_HEADING colubian_guard18 292.0
SET_CHAR_THREAT_SEARCH colubian_guard18 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard18 100
GIVE_WEAPON_TO_CHAR colubian_guard18 WEAPONTYPE_M16 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1125.4 448.8 -100.0 colubian_guard19 //On boxes
SET_CHAR_HEADING colubian_guard19 272.0
//ADD_ARMOUR_TO_CHAR colubian_guard19 100
SET_CHAR_THREAT_SEARCH colubian_guard19 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard19 WEAPONTYPE_M16 500
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard19 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1159.5 424.2 -100.0 colubian_guard22 //By boxes
SET_CHAR_HEADING colubian_guard22 278.0
//ADD_ARMOUR_TO_CHAR colubian_guard22 100
SET_CHAR_THREAT_SEARCH colubian_guard22 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard22 WEAPONTYPE_CHAINGUN 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1170.0 379.9 -100.0 colubian_guard23 //ground near heli pad
SET_CHAR_HEADING colubian_guard23 309.0
//ADD_ARMOUR_TO_CHAR colubian_guard23 100
SET_CHAR_THREAT_SEARCH colubian_guard23 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard23 WEAPONTYPE_CHAINGUN 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1171.7 384.8 -100.0 colubian_guard24 //ground near heli pad
SET_CHAR_HEADING colubian_guard24 309.0
//ADD_ARMOUR_TO_CHAR colubian_guard24 100
SET_CHAR_THREAT_SEARCH colubian_guard24 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard24 WEAPONTYPE_M16 500

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1156.8 407.5 -100.0 colubian_guard26 //ground near heli pad
SET_CHAR_HEADING colubian_guard26 319.0
//ADD_ARMOUR_TO_CHAR colubian_guard26 100
SET_CHAR_THREAT_SEARCH colubian_guard26 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard26 WEAPONTYPE_M16 500

	WHILE NOT IS_PLAYER_IN_AREA_3D player -1111.2 446.0 20.0 -1221.7 366.6 30.0 FALSE
		WAIT 0

		IF countdown_cat1 = 0
			PRINT_NOW ( OUTTIME ) 5000 1
			GOTO mission_cat1_failed
		ENDIF

		IF HAS_CATALINA_HELI_BEEN_SHOT_DOWN
			GOTO end_of_game
		ENDIF

		CLEAR_WANTED_LEVEL player

	ENDWHILE

//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard5
//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard6
//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard7
//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard8
//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard16
//MARK_CHAR_AS_NO_LONGER_NEEDED colubian_guard17
MARK_CAR_AS_NO_LONGER_NEEDED colubian_car2
MARK_CAR_AS_NO_LONGER_NEEDED colubian_car3

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1183.0 370.9 -100.0 colubian_guard9 //Below Heli Pad with flame thrower
SET_CHAR_HEADING colubian_guard9 342.0
SET_CHAR_THREAT_SEARCH colubian_guard9 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard9 100
GIVE_WEAPON_TO_CHAR colubian_guard9 WEAPONTYPE_FLAMETHROWER 1000
SET_CHAR_ACCURACY colubian_guard9 30

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1204.9 343.0 -100.0 colubian_guard10 //On heli pad with flame thrower
SET_CHAR_HEADING colubian_guard10 342.0
//ADD_ARMOUR_TO_CHAR colubian_guard10 100
SET_CHAR_THREAT_SEARCH colubian_guard10 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR colubian_guard10 WEAPONTYPE_FLAMETHROWER 1000
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard10 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1188.5 368.0 -100.0 colubian_guard20 //On heli pad with M16
SET_CHAR_HEADING colubian_guard20 7.0
SET_CHAR_THREAT_SEARCH colubian_guard20 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard20 100
GIVE_WEAPON_TO_CHAR colubian_guard20 WEAPONTYPE_M16 1000
SET_CHAR_ACCURACY colubian_guard20 30
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard20 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1176.3 357.1 -100.0 colubian_guard21 //On heli pad with AK47
SET_CHAR_HEADING colubian_guard21 58.0
SET_CHAR_THREAT_SEARCH colubian_guard21 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard21 100
GIVE_WEAPON_TO_CHAR colubian_guard21 WEAPONTYPE_CHAINGUN 1000
SET_CHAR_ACCURACY colubian_guard21 30
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard21 TRUE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1199.4 334.1 -100.0 colubian_guard25 //On heli pad with AK47
SET_CHAR_HEADING colubian_guard25 3.0
SET_CHAR_THREAT_SEARCH colubian_guard21 THREAT_PLAYER1
//ADD_ARMOUR_TO_CHAR colubian_guard25 100
GIVE_WEAPON_TO_CHAR colubian_guard25 WEAPONTYPE_CHAINGUN 1000
SET_CHAR_ACCURACY colubian_guard25 30
SET_CHAR_STAY_IN_SAME_PLACE colubian_guard25 TRUE
										 
CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 -1201.6 338.6 -100.0 maria
SET_CHAR_PROOFS maria TRUE TRUE TRUE TRUE TRUE
SET_ANIM_GROUP_FOR_CHAR maria ANIM_SEXY_WOMANPED
CHAR_LOOK_AT_PLAYER_ALWAYS maria Player
SET_CHAR_HEADING maria 339.0
maria_created_before = 1

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 -1182.0 346.1 -100.0 catalina
SET_CHAR_PROOFS catalina TRUE TRUE TRUE TRUE TRUE
SET_ANIM_GROUP_FOR_CHAR	catalina ANIM_SEXY_WOMANPED

//SHORT CATALINA ESCAPE CUT SCENE
	IF NOT IS_CHAR_DEAD catalina 
		SET_FIXED_CAMERA_POSITION -1190.6 334.4 32.1 0.0 0.0 0.0
		POINT_CAMERA_AT_CHAR maria FIXED JUMP_CUT
		SET_PLAYER_CONTROL Player OFF
		SWITCH_WIDESCREEN ON
		//SET_POLICE_IGNORE_PLAYER player ON
		SET_EVERYONE_IGNORE_PLAYER Player ON

		IF IS_PLAYER_IN_ANY_CAR Player
			APPLY_BRAKES_TO_PLAYERS_CAR Player ON
		ENDIF

		LOAD_MISSION_AUDIO C_1

		WAIT 3000

		IF NOT IS_CHAR_DEAD	catalina
			POINT_CAMERA_AT_CHAR catalina FIXED INTERPOLATION
			SET_CHAR_OBJ_RUN_TO_COORD catalina -1163.3 341.2
			PRINT_NOW ( CAT2_J ) 3000 2 // Mission brief
		ENDIF

		WHILE NOT HAS_MISSION_AUDIO_LOADED
			WAIT 0
		ENDWHILE

		PLAY_MISSION_AUDIO

	ENDIF

	WAIT 3000

//SWITCH_ROADS_ON -952.5 361.4 10.0 -939.3 374.0 30.0 // DAM

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL Player ON
RESTORE_CAMERA_JUMPCUT
DELETE_CHAR	catalina
//SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF

	IF IS_PLAYER_IN_ANY_CAR Player
		APPLY_BRAKES_TO_PLAYERS_CAR Player OFF
	ENDIF

WAIT 1000

IF NOT IS_CHAR_DEAD	maria
	SET_CHAR_PROOFS maria FALSE FALSE FALSE FALSE FALSE
ENDIF

	IF NOT IS_CAR_DEAD escape_chopper
		SET_CAR_PROOFS escape_chopper FALSE FALSE FALSE FALSE FALSE 
		CATALINA_HELI_TAKE_OFF
	ENDIF

IF NOT IS_CAR_DEAD colubian_car5
	CREATE_CHAR_INSIDE_CAR colubian_car5 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B colubian_guard11
	GIVE_WEAPON_TO_CHAR colubian_guard11 WEAPONTYPE_CHAINGUN 300
	SET_CAR_MISSION colubian_car5 MISSION_RAMPLAYER_FARAWAY
	SET_CAR_CRUISE_SPEED colubian_car5 40.0
	SET_CAR_DRIVING_STYLE colubian_car5 3
ENDIF

	  
	WHILE NOT HAS_CATALINA_HELI_BEEN_SHOT_DOWN 
		WAIT 0
		
		GET_PLAYER_COORDINATES Player playerx_cat playery_cat playerz_cat

		IF countdown_cat1 = 0
			PRINT_NOW ( OUTTIME ) 5000 1
			GOTO mission_cat1_failed
		ENDIF

		IF IS_CHAR_DEAD	maria
			PRINT_NOW ( BITCH_D ) 5000 1
			GOTO mission_cat1_failed  
		ENDIF
		
		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D Player maria 10.0 10.0 3.0 FALSE
			IF set_as_leader_before = 0
				STOP_CHAR_LOOKING maria
				SET_PLAYER_AS_LEADER maria player 
				set_as_leader_before = 1
			ENDIF 
		ELSE
			IF set_as_leader_before = 1
				set_as_leader_before = 0
			ENDIF
		ENDIF	
		/*
		IF NOT IS_CAR_DEAD escape_chopper
			IF LOCATE_PLAYER_ANY_MEANS_CAR_3D Player escape_chopper 20.0 20.0 30.0 FALSE
				GET_PLAYER_COORDINATES Player playerx_cat playery_cat playerz_cat
				//playerz_cat = playerz_cat + 1

				SET_FIXED_CAMERA_POSITION playerx_cat playery_cat playerz_cat 0.0 0.0 0.0
				POINT_CAMERA_AT_CAR escape_chopper FIXED INTERPOLATION
			ELSE
				RESTORE_CAMERA 
			ENDIF
		ENDIF
		*/
		IF IS_PLAYER_IN_AREA_3D Player -1142.0 327.8 29.0 -1215.6 368.4 40.0 FALSE
			IF been_on_heli_pad = 0
  				IF NOT IS_CHAR_DEAD	colubian_guard10
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard10 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard10 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard20
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard20 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard20 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard21
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard21 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard21 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard25
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard25 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard25 Player
				ENDIF

				been_on_heli_pad = 1
			ENDIF
		ENDIF
		
		CLEAR_WANTED_LEVEL player
					
	ENDWHILE

//RESTORE_CAMERA

end_of_game:

SET_FADING_COLOUR 255 255 255
DO_FADE 500 FADE_OUT

CLEAR_ONSCREEN_TIMER countdown_cat1
REMOVE_CATALINA_HELI

IF maria_created_before = 0
	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 -1201.6 338.6 -100.0 maria
	SET_CHAR_PROOFS maria TRUE TRUE TRUE TRUE TRUE
	SET_ANIM_GROUP_FOR_CHAR	maria ANIM_SEXY_WOMANPED
	CHAR_LOOK_AT_PLAYER_ALWAYS maria Player
	SET_CHAR_HEADING maria 339.0
ENDIF

DO_FADE 500 FADE_IN

	WHILE NOT IS_CHAR_IN_PLAYERS_GROUP maria Player
		WAIT 0

		IF IS_CHAR_DEAD	maria
			PRINT_NOW ( BITCH_D ) 5000 1
			GOTO mission_cat1_failed  
		ENDIF

		IF NOT IS_CHAR_IN_PLAYERS_GROUP maria Player
			IF added_the_blip_for_maria = 0
				ADD_BLIP_FOR_CHAR maria marias_blip
				added_the_blip_for_maria = 1
			ENDIF
		ELSE
			IF added_the_blip_for_maria = 1
				REMOVE_BLIP marias_blip
				added_the_blip_for_maria = 0
			ENDIF
		ENDIF

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D Player maria 10.0 10.0 3.0 FALSE
			IF set_as_leader_before = 0
				STOP_CHAR_LOOKING maria
				SET_PLAYER_AS_LEADER maria player 
				set_as_leader_before = 1
			ENDIF 
		ELSE
			IF set_as_leader_before = 1
				set_as_leader_before = 0
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_AREA_3D Player -1142.0 327.8 29.0 -1215.6 368.4 40.0 FALSE
			IF been_on_heli_pad = 0
				IF NOT IS_CHAR_DEAD	colubian_guard10
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard10 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard10 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard20
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard20 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard20 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard21
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard21 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard21 Player
				ENDIF
				IF NOT IS_CHAR_DEAD	colubian_guard25
					SET_CHAR_STAY_IN_SAME_PLACE colubian_guard25 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colubian_guard25 Player
				ENDIF

				been_on_heli_pad = 1
			ENDIF
		ENDIF

		CLEAR_WANTED_LEVEL player
		
	ENDWHILE

//last_cutscene:	//TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	GET_GAME_TIMER breakout_timer_start
	breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		IF IS_CHAR_DEAD	maria
			PRINT_NOW ( BITCH_D ) 5000 1
			GOTO mission_cat1_failed  
		ENDIF

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player


//END OF GAME CUT_SCENE***************************************************************************************************

CLEAR_WANTED_LEVEL player
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//PRINT_BIG ( CAT2 ) 5000 2 //"Catalina"

TIMERA = 0

FORCE_WEATHER_NOW WEATHER_SUNNY

WHILE TIMERA < 1500
	WAIT 0

ENDWHILE

LOAD_SPECIAL_CHARACTER 1 Maria
	
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

LOAD_CUTSCENE END
LOAD_END_OF_GAME_TUNE
SET_CUTSCENE_OFFSET -1031.7601 451.7612 22.5624 

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

//CREATE_CUTSCENE_HEAD cs_maria CUT_OBJ1 cs_mariahead
//SET_CUTSCENE_HEAD_ANIM cs_mariahead maria

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

//CLEAR_AREA -381.8 284.0 62.9 1.0 TRUE
//SET_PLAYER_COORDINATES player -381.8 284.0 -100.0
//SET_PLAYER_HEADING player 232.0

IF NOT IS_CHAR_DEAD	colubian_guard8
	SET_CHAR_HEALTH	colubian_guard8 0
ENDIF

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE
PLAY_END_OF_GAME_TUNE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 5507
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_A ) 10000 2 // Mission brief

WHILE cs_time < 7855
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_B ) 10000 2 // Mission brief

WHILE cs_time < 10313
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_C ) 10000 2 // Mission brief

WHILE cs_time < 13610
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_D ) 10000 2 // Mission brief

WHILE cs_time < 16428
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_E ) 10000 2 // Mission brief

WHILE cs_time < 20514
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_F ) 10000 2 // Mission brief

WHILE cs_time < 22827
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_G ) 10000 2 // Mission brief

WHILE cs_time < 26173
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_H ) 10000 2 // Mission brief

WHILE cs_time < 28028
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_I ) 10000 2 // Mission brief

WHILE cs_time < 29276
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_J ) 10000 2 // Mission brief

WHILE cs_time < 31901
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_K ) 10000 2 // Mission brief

WHILE cs_time < 35772
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_L ) 10000 2 // Mission brief

WHILE cs_time < 38820
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_M ) 10000 2 // Mission brief

WHILE cs_time < 42136
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_N ) 10000 2 // Mission brief

WHILE cs_time < 44646
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_O ) 10000 2 // Mission brief

WHILE cs_time < 46971
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_P ) 10000 2 // Mission brief

WHILE cs_time < 49254
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_Q ) 10000 2 // Mission brief

WHILE cs_time < 51621
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_R ) 10000 2 // Mission brief

WHILE cs_time < 54000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_S ) 10000 2 // Mission brief

WHILE cs_time < 56584
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_T ) 10000 2 // Mission brief

WHILE cs_time < 59278
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( END_U ) 4000 2 // Mission brief

WHILE cs_time < 66666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE


SET_MUSIC_DOES_FADE FALSE

SET_FADING_COLOUR 1 1 1
DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

//SWITCH_WORLD_PROCESSING ON
CLEAR_PRINTS
CLEAR_CUTSCENE

GOSUB mission_start_credits
//SET_CAMERA_BEHIND_PLAYER


}
GOTO mission_cat1_passed


 // Mission cat1 failed

mission_cat1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
	IF NOT IS_CHAR_DEAD	maria
		REMOVE_CHAR_ELEGANTLY maria 
	ENDIF
RETURN

   

// mission cat1 passed

mission_cat1_passed:							 

flag_cat_mission1_passed = 1
flag_suburban_passed = 1
//PLAY_MISSION_PASSED_TUNE 1
//PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	CAT2
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP maria_contact_blip
SWITCH_CAR_GENERATOR special_tank 101
SUBURBAN_PASSED
//START_NEW_SCRIPT credits_loop
RETURN
		


// mission cleanup

mission_cleanup_cat1:

flag_player_on_mission = 0
flag_player_on_cat_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_FLATBED
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
//SET_FADING_COLOUR 0 0 0
CLEAR_ONSCREEN_TIMER countdown_cat1
SWITCH_PED_ROADS_ON -942.6 337.0 10.0 -953.6 361.4 30.0 // DAM
REMOVE_BLIP blip1_cat1 
REMOVE_BLIP marias_blip
DELETE_CHAR	catalina
REMOVE_CATALINA_HELI
REMOVE_PICKUP rocket_launch
REMOVE_PICKUP Dead_guards_gun
SETUP_ZONE_PED_INFO WEE_DAM DAY   (8) 0 0 0 0 0 100 0 0  
SETUP_ZONE_PED_INFO WEE_DAM NIGHT (5) 0 0 0 0 0 100 0 0
SETUP_ZONE_CAR_INFO WEE_DAM DAY   (0) 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO WEE_DAM NIGHT (0) 0 0 0 0 0 0 0 0 0 0 0 0 0	0
//DO_FADE 0 FADE_OUT
//CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_COLOMBIAN THREAT_PLAYER1
MISSION_HAS_FINISHED
RETURN





// **************************************CREDITS************************************************

mission_start_credits:
{
WAIT 0
SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_PLAYER_VISIBLE player FALSE
SWITCH_RUBBISH OFF
SWITCH_WIDESCREEN ON
ADD_SCORE player 1000000

START_CREDITS
TIMERA = 0
SET_TIME_OF_DAY 2 40
GOTO first_credits_loop

WHILE NOT ARE_CREDITS_FINISHED 
	WAIT 0

	IF camera_cut = 0

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF

		ENDWHILE

		first_credits_loop:

		SET_PLAYER_COORDINATES player -361.9 248.0 -100.0 // Colubian mansion
		SET_FIXED_CAMERA_POSITION -364.393 265.064 82.87 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -363.973 264.189 82.632 JUMP_CUT

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0

			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 30000
			WAIT 0

			IF TIMERA > 40000
				IF IS_BUTTON_PRESSED PAD1 CROSS
					GOTO final_final_scene
				ENDIF
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
				
		ENDWHILE

		camera_cut = 1	
	ENDIF
	
	IF camera_cut = 1

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		SET_PLAYER_COORDINATES player -1174.25 -7.017 -100.0 // Industrial bit
		SET_FIXED_CAMERA_POSITION -1176.481 -17.694 75.992 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -1175.726 -17.055 75.847 JUMP_CUT
		SET_TIME_OF_DAY 5 40

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 30000
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
				
		ENDWHILE

		camera_cut = 2	
	ENDIF

	IF camera_cut = 2

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		SET_PLAYER_COORDINATES player -468.7 -3.3 -100.0 // Projects
		SET_FIXED_CAMERA_POSITION -413.07 19.261 54.403 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -413.942 18.976 54.006 JUMP_CUT

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 30000
			WAIT 0 

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
							
		ENDWHILE

		camera_cut = 3	
	ENDIF
	
	IF camera_cut = 3

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		SET_PLAYER_COORDINATES player -855.7 -717.3 -100.0 // Airport
		SET_FIXED_CAMERA_POSITION -959.517 -656.414 55.464 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -958.668 -656.912 55.288 JUMP_CUT
		SET_TIME_OF_DAY 22 0

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 30000
			WAIT 0 

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
							
		ENDWHILE

		camera_cut = 4	
	ENDIF

	IF camera_cut = 4

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		SET_PLAYER_COORDINATES player -532.7 -611.7 43.3 // Bridge
		SET_FIXED_CAMERA_POSITION -571.592 -611.137 67.566 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -570.697 -611.579 67.493 JUMP_CUT

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 30000
			WAIT 0 

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
							
		ENDWHILE

		camera_cut = 5	
	ENDIF

	IF camera_cut = 5

		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		SET_PLAYER_COORDINATES player -671.6 -155.9 -100.0 // Twisted Bridge
		SET_FIXED_CAMERA_POSITION -706.590 -219.085 25.797 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -706.155 -218.190 25.696 JUMP_CUT
		SET_TIME_OF_DAY 1 20
		FORCE_WEATHER_NOW WEATHER_RAINY

		TIMERB = 0

		WHILE TIMERB < 20000
			WAIT 0
			
			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF

			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF

		ENDWHILE

		DO_FADE 1500 FADE_IN
		TIMERB = 0

		WHILE TIMERB < 40000
			WAIT 0 

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO final_final_scene
			ENDIF
			
			IF ARE_CREDITS_FINISHED
				GOTO final_final_scene
			ENDIF
							
		ENDWHILE

		camera_cut = 0	
	ENDIF
									  	
ENDWHILE

// **********************************END OF CAMERA CUTSCENE****************************

final_final_scene:

STOP_CREDITS
//FORCE_WEATHER_NOW WEATHER_CLOUDY   			

//SET_FADING_COLOUR 0 0 0
SET_TIME_OF_DAY 7 00

SET_MUSIC_DOES_FADE TRUE

DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PLAYER_VISIBLE player TRUE
SET_PLAYER_HEALTH player 100
CLEAR_AREA -666.8 -1.8 18.8 2.0 TRUE
SET_PLAYER_COORDINATES player -666.8 -1.8 -100.0
LOAD_SCENE -666.8 -1.8 19.0
SET_PLAYER_HEADING player 180.0
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER
SWITCH_WIDESCREEN OFF
TIMERB = 0

flag_player_on_mission = 0
flag_player_on_cat_mission = 0

TIMERB = 0

WHILE TIMERB < 2500
	WAIT 0

ENDWHILE

DO_FADE 2000 FADE_IN
STOP_END_OF_GAME_TUNE

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

RETURN

}