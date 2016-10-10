<?php global $woocommerce; ?>

<?php
$logo = '';
 
if ( function_exists( 'has_custom_logo' ) ) {
	if ( has_custom_logo() ) {
		$logo = get_custom_logo();
	}
} else if ( get_theme_mod( 'panoramic-logo', '' ) != '' ) {
	$logo = "<a href=\"". esc_url( home_url( '/' ) ) ."\" title=\"". esc_attr( get_bloginfo( 'name', 'display' ) ) ."\"><img src=\"". esc_url( get_theme_mod( 'panoramic-logo', '' ) ) ."\" alt=\"". esc_attr( get_bloginfo( 'name' ) ) ."\" /></a>";
}
?>

<div class="site-container">
    
    <div class="branding">
        <?php
        if( $logo ) :
       		echo $logo;
        else :
        ?>
            <a href="<?php echo esc_url( home_url( '/' ) ); ?>" title="<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>" class="title"><?php bloginfo( 'name' ); ?></a>
            <div class="description"><?php bloginfo( 'description' ); ?></div>
        <?php
        endif;
        ?>
    </div><!-- .site-branding -->
    
    <div class="site-header-right">
        
        <?php
        if ( panoramic_is_woocommerce_activated() && get_theme_mod( 'panoramic-header-shop-links', true ) ) { ?>
        
            <?php if ( is_user_logged_in() ) { ?>
                <div class="site-header-right-link"><a href="<?php echo get_permalink( get_option('woocommerce_myaccount_page_id') ); ?>" class="my-account" title="<?php _e('My Account','panoramic'); ?>"><?php _e('My Account','panoramic'); ?></a></div>
            <?php } else { ?>
                <div class="site-header-right-link"><a href="<?php echo get_permalink( get_option('woocommerce_myaccount_page_id') ); ?>" class="my-account" title="<?php _e('Login','panoramic'); ?>"><?php _e('Sign In / Register','panoramic'); ?></a></div>
            <?php } ?>
            <div class="header-cart">
                <a class="header-cart-contents" href="<?php echo $woocommerce->cart->get_cart_url(); ?>" title="<?php _e('View your shopping cart', 'panoramic'); ?>">
                    <span class="header-cart-amount">
                        <?php echo sprintf(_n('%d item', '%d items', $woocommerce->cart->cart_contents_count, 'panoramic'), $woocommerce->cart->cart_contents_count);?> - <?php echo $woocommerce->cart->get_cart_total(); ?>
                    </span>
                    <span class="header-cart-checkout<?php echo ( $woocommerce->cart->cart_contents_count > 0 ) ? ' cart-has-items' : ''; ?>">
                        <span><?php _e('Checkout', 'panoramic'); ?></span> <i class="fa fa-shopping-cart"></i>
                    </span>
                </a>
            </div>
            
        <?php
        } else {
		?>
            <div class="info-text">
            	<?php echo wp_kses_post( get_theme_mod( 'panoramic-header-info-text', __( '<strong><em>CALL US:</em></strong> 555-PANORAMIC', 'panoramic' ) ) ) ?>
            </div>
			<?php get_template_part( 'library/template-parts/social-links' ); ?>
        <?php
        }
        ?>
        
    </div>
    <div class="clearboth"></div>
    
	<?php if( get_theme_mod( 'panoramic-header-search', true ) ) : ?>
	<div class="search-block">
		<?php get_search_form(); ?>
	</div>
	<?php endif; ?>
    
</div>

<?php 
$is_translucent = true;

if ( !is_front_page() ) {
	$is_translucent = false;
} else if ( is_front_page() && get_theme_mod( 'panoramic-slider-type', 'panoramic-no-slider' ) == 'panoramic-no-slider' && !get_header_image() ) {
	$is_translucent = false;
} else if ( is_front_page() && get_theme_mod( 'panoramic-slider-type', 'panoramic-no-slider' ) == 'panoramic-slider-plugin' && get_theme_mod( 'panoramic-slider-plugin-shortcode', '' ) == '' ) {
	$is_translucent = false;
}
?>
        
<nav id="site-navigation" class="main-navigation border-bottom <?php echo ( $is_translucent ) ? sanitize_html_class( 'translucent' ) : sanitize_html_class( '' ); ?>" role="navigation">
	<span class="header-menu-button"><i class="fa fa-bars"></i></span>
	<div id="main-menu" class="main-menu-container panoramic-mobile-menu-standard-color-scheme">
		<div class="main-menu-close"><i class="fa fa-angle-right"></i><i class="fa fa-angle-left"></i></div>
		<?php wp_nav_menu( array( 'theme_location' => 'primary', 'container_class' => 'main-navigation-inner' ) ); ?>
	</div>
</nav><!-- #site-navigation -->
