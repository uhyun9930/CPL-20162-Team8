<?php
/**
 * This is a fallback sidebar
 *
 * @package panoramic
 */

if ( ! is_active_sidebar( 'sidebar-1' ) ) {
?>
	<div id="secondary" class="widget-area" role="complementary">
		<div class="notice">
			<?php _e( 'Add widgets to the Sidebar at Appearance > Widgets', 'panoramic' ); ?>
		</div>
	</div>
<?php	
	return;
} else {
?>
	<div id="secondary" class="widget-area" role="complementary">
		<?php dynamic_sidebar( 'sidebar-1' ); ?>
	</div><!-- #secondary -->
<?php
}
?>