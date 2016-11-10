<div class="header-image loading">
	<img src="<?php esc_url( header_image() ); ?>" height="<?php echo get_custom_header()->height; ?>" width="<?php echo get_custom_header()->width; ?>" />
	
	<?php
	if ( get_theme_mod( 'panoramic-header-image-text', '' ) != "" ) {
	?>
	<div class="overlay top-padded">
		<div class="opacity">
			<?php echo wp_kses_post( get_theme_mod( 'panoramic-header-image-text', '' ) ); ?>
		</div>
	</div>	
	<?php 
	}
	?>
	
</div>