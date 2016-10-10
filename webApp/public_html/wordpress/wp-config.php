<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'wordpress');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', 'autoset');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'nt)HIv?oyc:?VsgZDpHajSIh;PLc=jM=V EA%Tpq1jA__g_oua7ZTe-9uAY.eSpb');
define('SECURE_AUTH_KEY',  '^kM/cr9mo:~r<J_R`F*LOzyiedpDFd+M+7@@z3P^#~16yL,hxacd=sy{%[VQ/(}v');
define('LOGGED_IN_KEY',    '?lso%5Xl)ra*g&9lj$8F5!8JXP#3nyLSZ#pRZ=@bBR zmXt%C]dB1P-mT>6>Wl$k');
define('NONCE_KEY',        'Oq=1dZQUueRT!#WuK%CB+`@*&vFHZ!6S7Dt!*UHXxTcJ :OF p{Ql!A-EaISzY|]');
define('AUTH_SALT',        '*03}%l8/+.2z#I$WD0Ts:o3Q|4/^oJ[/j|h<#<S!)~tbL%CqvOrjPwWe2l->E>]^');
define('SECURE_AUTH_SALT', '#z}iP}m.P,m_HJ_Dm=Nd|k%4M$s8BiogJwi @uU_5lM) N}L+,S3,ydgJxIb(n|V');
define('LOGGED_IN_SALT',   '%z:,5X,f3&64#uW!O:Em/t-.%OX0~7/x|J`fD+T#R:#Ok>%jje}5_H|rM&h8yvRH');
define('NONCE_SALT',       '%:[ e?oD9?z_uSkc#k]!rl)^,=s LT.1?}@$-=eDIh?}D++-CRB -(lH}:yv:3xu');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
