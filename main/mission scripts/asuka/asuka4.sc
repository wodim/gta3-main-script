MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************asuka mission 4******************************** 
// ******************************************Pay day for Ray********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_asuka4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_asuka4_failed
ENDIF

GOSUB mission_cleanup_asuka4

MISSION_END
 
// Variables for mission

VAR_INT blip1_as4 timer_frozen

VAR_INT countdown_as4 phone_1_obj phone_2_obj phone_3_obj phone_4_obj


// ****************************************Mission Start************************************

mission_start_asuka4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_asuka_mission = 1
SCRIPT_NAME asuka4
WAIT 0


{

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 ASUKAH
LOAD_SPECIAL_MODEL cut_obj3	minnote
LOAD_SPECIAL_CHARACTER 1 asuka
REQUEST_MODEL condo_ivy
REQUEST_MODEL kmricndo01


LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3 
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED condo_ivy
OR NOT HAS_MODEL_LOADED	kmricndo01
	WAIT 0

ENDWHILE

LOAD_CUTSCENE A4_PDR
SET_CUTSCENE_OFFSET 523.102 -636.96 15.616

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ2 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

CREATE_CUTSCENE_OBJECT cut_obj3 cs_note
SET_CUTSCENE_ANIM cs_note minnote

CLEAR_AREA 523.6 -639.4 16.6 1.0 TRUE
SET_PLAYER_COORDINATES player 523.6 -639.4 16.0

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 805
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_A ) 10000 1 

WHILE cs_time < 3370
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_B ) 10000 1 

WHILE cs_time < 6758
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_C ) 10000 1 

WHILE cs_time < 12673
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_D ) 10000 1 

WHILE cs_time < 15481
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_E ) 10000 1 

WHILE cs_time < 18606
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_F ) 10000 1 

WHILE cs_time < 21381
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_G ) 10000 1 

WHILE cs_time < 25955
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 29333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED condo_ivy
MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01
UNLOAD_SPECIAL_CHARACTER 1
    
//GOTO skip_to_ray_cut //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

// MISSION START

CREATE_OBJECT_NO_OFFSET faketarget 229.2 -1537.6 26.0 phone_1_obj
DONT_REMOVE_OBJECT phone_1_obj

CREATE_OBJECT_NO_OFFSET faketarget -53.5 -699.1 26.0 phone_2_obj
DONT_REMOVE_OBJECT phone_2_obj

CREATE_OBJECT_NO_OFFSET faketarget 204.8 -135.0 16.0 phone_3_obj
DONT_REMOVE_OBJECT phone_3_obj

CREATE_OBJECT_NO_OFFSET faketarget 60.3 -964.8 26.1 phone_4_obj
DONT_REMOVE_OBJECT phone_4_obj

	countdown_as4 = 211000
	DISPLAY_ONSCREEN_TIMER countdown_as4
	ADD_BLIP_FOR_OBJECT phone_1_obj blip1_as4
	SET_PHONE_MESSAGE Ray_phone1 ( AM4_1A )
	LOAD_MISSION_AUDIO A4_A

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 229.2 -1537.6 26.0 1.0 1.0 3.0 FALSE //PHONE1
OR NOT IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

	IF countdown_as4 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_asuka4_failed		 
	ENDIF

ENDWHILE

	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player On
	FREEZE_ONSCREEN_TIMER TRUE
	SET_FIXED_CAMERA_POSITION 214.844 -1549.911 32.448 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 215.507 -1549.246 32.105 JUMP_CUT

WHILE NOT IS_PHONE_DISPLAYING_MESSAGE Ray_phone1
	WAIT 0

ENDWHILE

	PLAY_MISSION_AUDIO

WHILE IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

ENDWHILE

	RESTORE_CAMERA_JUMPCUT
	FREEZE_ONSCREEN_TIMER FALSE
	REMOVE_BLIP blip1_as4
	ADD_BLIP_FOR_OBJECT phone_2_obj blip1_as4
	SET_PHONE_MESSAGE Ray_phone2 ( AM4_1B )
	SET_POLICE_IGNORE_PLAYER Player off
	SET_EVERYONE_IGNORE_PLAYER Player off

	LOAD_MISSION_AUDIO A4_B

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player -53.5 -699.1 26.0 1.0 1.0 3.0 FALSE //PHONE2
OR NOT IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

	IF countdown_as4 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_asuka4_failed	 
	ENDIF

ENDWHILE

	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player On
	FREEZE_ONSCREEN_TIMER TRUE
	SET_FIXED_CAMERA_POSITION -77.442 -702.532 33.574 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -76.500 -702.391 33.270 JUMP_CUT

WHILE NOT IS_PHONE_DISPLAYING_MESSAGE Ray_phone2
	WAIT 0

ENDWHILE

	PLAY_MISSION_AUDIO

WHILE IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

ENDWHILE

	RESTORE_CAMERA_JUMPCUT
	FREEZE_ONSCREEN_TIMER FALSE
	REMOVE_BLIP blip1_as4
	ADD_BLIP_FOR_OBJECT phone_3_obj blip1_as4
	SET_PHONE_MESSAGE Ray_phone3 ( AM4_1C )
	SET_POLICE_IGNORE_PLAYER Player off
	SET_EVERYONE_IGNORE_PLAYER Player off

	LOAD_MISSION_AUDIO A4_C

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 204.8 -135.0 16.0 1.0 1.0 3.0 FALSE //PHONE3
OR NOT IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

	IF countdown_as4 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_asuka4_failed	 
	ENDIF

ENDWHILE

	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player On
	FREEZE_ONSCREEN_TIMER TRUE
	SET_FIXED_CAMERA_POSITION 191.656 -130.530 20.037 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 192.560 -130.834 19.734 JUMP_CUT

WHILE NOT IS_PHONE_DISPLAYING_MESSAGE Ray_phone3
	WAIT 0

ENDWHILE

	PLAY_MISSION_AUDIO

WHILE IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

ENDWHILE

	RESTORE_CAMERA_JUMPCUT
	FREEZE_ONSCREEN_TIMER FALSE
	REMOVE_BLIP blip1_as4
	ADD_BLIP_FOR_OBJECT phone_4_obj blip1_as4
	SET_PHONE_MESSAGE Ray_phone4 ( AM4_1D )
	SET_POLICE_IGNORE_PLAYER Player off
	SET_EVERYONE_IGNORE_PLAYER Player off

	LOAD_MISSION_AUDIO A4_D

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 60.3 -964.8 26.1 1.0 1.0 3.0 FALSE //PHONE4
OR NOT IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

	IF countdown_as4 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_asuka4_failed 	 
	ENDIF

ENDWHILE

	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player On
	FREEZE_ONSCREEN_TIMER TRUE
	SET_FIXED_CAMERA_POSITION 51.733 -973.067 30.559 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 52.418 -972.450 30.172 JUMP_CUT

WHILE NOT IS_PHONE_DISPLAYING_MESSAGE Ray_phone4
	WAIT 0

ENDWHILE

	PLAY_MISSION_AUDIO

WHILE IS_PLAYER_LIFTING_A_PHONE player
	WAIT 0

ENDWHILE

	RESTORE_CAMERA_JUMPCUT
	CLEAR_ONSCREEN_TIMER countdown_as4
	REMOVE_BLIP blip1_as4
	ADD_BLIP_FOR_COORD 38.8 -725.4 22.8 blip1_as4
	SET_POLICE_IGNORE_PLAYER Player off
	SET_EVERYONE_IGNORE_PLAYER Player off

rays_cutscene_flag = 1

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 38.8 -725.4 22.8 1.0 1.0 2.0 TRUE
	WAIT 0

ENDWHILE

REMOVE_BLIP blip1_as4


//skip_to_ray_cut: //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//SET_PLAYER_COORDINATES player 44.2 -725.0 24.7 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


GET_GAME_TIMER breakout_timer_start
breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
	WAIT 0

	GET_GAME_TIMER breakout_timer							
	breakout_diff = breakout_timer - breakout_timer_start
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

//RAY CUT SCENE*************************************************************************
CLEAR_WANTED_LEVEL player
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF
	 
LOAD_SPECIAL_CHARACTER 2 ray
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 RAYH

WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2 
	WAIT 0

ENDWHILE

LOAD_CUTSCENE R0_PDR2
SET_CUTSCENE_OFFSET 39.424 -726.677 21.692

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_ray
SET_CUTSCENE_ANIM cs_ray ray

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2887
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_3 ) 10000 1 

WHILE cs_time < 6583
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_4 ) 10000 1 

WHILE cs_time < 10279
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_5 ) 10000 1 

WHILE cs_time < 13282
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_6 ) 10000 1 

WHILE cs_time < 15014
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_7 ) 10000 1 

WHILE cs_time < 20212
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_8 ) 10000 1 

WHILE cs_time < 21944
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_9 ) 10000 1 

WHILE cs_time < 24716
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_10 ) 10000 1 

WHILE cs_time < 27719
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM4_11 ) 10000 1 

WHILE cs_time < 30611
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 31666
	WAIT 0							 
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

SWITCH_RUBBISH ON
CLEAR_PRINTS
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2

}

GOTO mission_asuka4_passed
	   		

// Mission asuka4 failed

mission_asuka4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission asuka4 passed

mission_asuka4_passed:

flag_asuka_mission4_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 11000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 11000
REGISTER_MISSION_PASSED	AM4
PLAYER_MADE_PROGRESS 1
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 38.8 -725.4 -100.0 RADAR_SPRITE_RAY ray_contact_blip 
SET_CAMERA_BEHIND_PLAYER
START_NEW_SCRIPT asuka_mission5_loop
START_NEW_SCRIPT ray_mission1_loop
RETURN
		


// mission cleanup

mission_cleanup_asuka4:

flag_player_on_mission = 0
flag_player_on_asuka_mission = 0
CLEAR_ONSCREEN_TIMER countdown_as4
REMOVE_BLIP blip1_as4
TURN_PHONE_OFF Ray_phone1
TURN_PHONE_OFF Ray_phone2
TURN_PHONE_OFF Ray_phone3
TURN_PHONE_OFF Ray_phone4
DELETE_OBJECT phone_1_obj
DELETE_OBJECT phone_2_obj
DELETE_OBJECT phone_3_obj
DELETE_OBJECT phone_4_obj
rays_cutscene_flag = 0
FREEZE_ONSCREEN_TIMER FALSE
MISSION_HAS_FINISHED
RETURN
		


