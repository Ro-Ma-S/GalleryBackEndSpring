PGDMP      +            
    |            artsellingdb_postgresql    16.3    16.3 G               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16414    artsellingdb_postgresql    DATABASE     �   CREATE DATABASE artsellingdb_postgresql WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_India.1252';
 '   DROP DATABASE artsellingdb_postgresql;
                postgres    false            �            1259    16452    artworks_table    TABLE     8  CREATE TABLE public.artworks_table (
    artwork_id integer NOT NULL,
    title character varying(255) NOT NULL,
    description text,
    user_id integer NOT NULL,
    category character varying(100),
    style character varying(100),
    creation_date date,
    price numeric(10,2) NOT NULL,
    dimensions character varying(100),
    medium character varying(100),
    image_url character varying(255),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT artworks_table_user_id_check CHECK (((user_id >= 4) AND (user_id <= 12)))
);
 "   DROP TABLE public.artworks_table;
       public         heap    postgres    false            �            1259    16451    artworks_table_artwork_id_seq    SEQUENCE     �   CREATE SEQUENCE public.artworks_table_artwork_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.artworks_table_artwork_id_seq;
       public          postgres    false    218                       0    0    artworks_table_artwork_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.artworks_table_artwork_id_seq OWNED BY public.artworks_table.artwork_id;
          public          postgres    false    217            �            1259    16470    bidding_table    TABLE     �   CREATE TABLE public.bidding_table (
    bid_id integer NOT NULL,
    artwork_id integer NOT NULL,
    user_id integer NOT NULL,
    bid_amount numeric(10,2) NOT NULL,
    bid_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 !   DROP TABLE public.bidding_table;
       public         heap    postgres    false            �            1259    16469    bidding_table_bid_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bidding_table_bid_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.bidding_table_bid_id_seq;
       public          postgres    false    220                       0    0    bidding_table_bid_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.bidding_table_bid_id_seq OWNED BY public.bidding_table.bid_id;
          public          postgres    false    219            �            1259    16488    events_table    TABLE     �  CREATE TABLE public.events_table (
    event_id integer NOT NULL,
    event_name character varying(255) NOT NULL,
    description text,
    user_id integer NOT NULL,
    event_start_date date,
    event_end_date date,
    location character varying(255),
    registration_form_link character varying(255),
    link_end_date date,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
     DROP TABLE public.events_table;
       public         heap    postgres    false            �            1259    16487    events_table_event_id_seq    SEQUENCE     �   CREATE SEQUENCE public.events_table_event_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.events_table_event_id_seq;
       public          postgres    false    222                       0    0    events_table_event_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.events_table_event_id_seq OWNED BY public.events_table.event_id;
          public          postgres    false    221            �            1259    16503    gallery_table    TABLE       CREATE TABLE public.gallery_table (
    gallery_id integer NOT NULL,
    name character varying(255) NOT NULL,
    location character varying(255),
    description text,
    user_id integer NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 !   DROP TABLE public.gallery_table;
       public         heap    postgres    false            �            1259    16502    gallery_table_gallery_id_seq    SEQUENCE     �   CREATE SEQUENCE public.gallery_table_gallery_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.gallery_table_gallery_id_seq;
       public          postgres    false    224                       0    0    gallery_table_gallery_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.gallery_table_gallery_id_seq OWNED BY public.gallery_table.gallery_id;
          public          postgres    false    223            �            1259    16518    messages_review_table    TABLE     c  CREATE TABLE public.messages_review_table (
    review_id integer NOT NULL,
    user_id integer NOT NULL,
    artwork_id integer NOT NULL,
    rating integer,
    review_text text NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT messages_review_table_rating_check CHECK (((rating >= 1) AND (rating <= 5)))
);
 )   DROP TABLE public.messages_review_table;
       public         heap    postgres    false            �            1259    16517 #   messages_review_table_review_id_seq    SEQUENCE     �   CREATE SEQUENCE public.messages_review_table_review_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.messages_review_table_review_id_seq;
       public          postgres    false    226                       0    0 #   messages_review_table_review_id_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.messages_review_table_review_id_seq OWNED BY public.messages_review_table.review_id;
          public          postgres    false    225            �            1259    16540    orders_table    TABLE     �  CREATE TABLE public.orders_table (
    order_id integer NOT NULL,
    user_id integer NOT NULL,
    artwork_id integer NOT NULL,
    order_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    total_price numeric(10,2) NOT NULL,
    status character varying(50) DEFAULT 'pending'::character varying,
    shipping_address text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
     DROP TABLE public.orders_table;
       public         heap    postgres    false            �            1259    16539    orders_table_order_id_seq    SEQUENCE     �   CREATE SEQUENCE public.orders_table_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.orders_table_order_id_seq;
       public          postgres    false    228                       0    0    orders_table_order_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.orders_table_order_id_seq OWNED BY public.orders_table.order_id;
          public          postgres    false    227            �            1259    16572    paymenttransactions_table    TABLE     �  CREATE TABLE public.paymenttransactions_table (
    transaction_id integer NOT NULL,
    order_id integer NOT NULL,
    user_id integer NOT NULL,
    payment_method character varying(50),
    transaction_date date NOT NULL,
    transaction_time time without time zone NOT NULL,
    amount numeric(10,2) NOT NULL,
    status character varying(50) DEFAULT 'completed'::character varying,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 -   DROP TABLE public.paymenttransactions_table;
       public         heap    postgres    false            �            1259    16571 ,   paymenttransactions_table_transaction_id_seq    SEQUENCE     �   CREATE SEQUENCE public.paymenttransactions_table_transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 C   DROP SEQUENCE public.paymenttransactions_table_transaction_id_seq;
       public          postgres    false    230                       0    0 ,   paymenttransactions_table_transaction_id_seq    SEQUENCE OWNED BY     }   ALTER SEQUENCE public.paymenttransactions_table_transaction_id_seq OWNED BY public.paymenttransactions_table.transaction_id;
          public          postgres    false    229            �            1259    16430    users_table    TABLE     ?  CREATE TABLE public.users_table (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    first_name character varying(50),
    last_name character varying(50),
    profile_picture character varying(255),
    bio text,
    category character varying(50) DEFAULT 'buyer'::character varying NOT NULL,
    phone_number character varying(20),
    address text,
    gender character varying(10),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.users_table;
       public         heap    postgres    false            �            1259    16429    users_table_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_table_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.users_table_user_id_seq;
       public          postgres    false    216                       0    0    users_table_user_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.users_table_user_id_seq OWNED BY public.users_table.user_id;
          public          postgres    false    215            @           2604    16455    artworks_table artwork_id    DEFAULT     �   ALTER TABLE ONLY public.artworks_table ALTER COLUMN artwork_id SET DEFAULT nextval('public.artworks_table_artwork_id_seq'::regclass);
 H   ALTER TABLE public.artworks_table ALTER COLUMN artwork_id DROP DEFAULT;
       public          postgres    false    217    218    218            B           2604    16473    bidding_table bid_id    DEFAULT     |   ALTER TABLE ONLY public.bidding_table ALTER COLUMN bid_id SET DEFAULT nextval('public.bidding_table_bid_id_seq'::regclass);
 C   ALTER TABLE public.bidding_table ALTER COLUMN bid_id DROP DEFAULT;
       public          postgres    false    220    219    220            D           2604    16491    events_table event_id    DEFAULT     ~   ALTER TABLE ONLY public.events_table ALTER COLUMN event_id SET DEFAULT nextval('public.events_table_event_id_seq'::regclass);
 D   ALTER TABLE public.events_table ALTER COLUMN event_id DROP DEFAULT;
       public          postgres    false    222    221    222            F           2604    16506    gallery_table gallery_id    DEFAULT     �   ALTER TABLE ONLY public.gallery_table ALTER COLUMN gallery_id SET DEFAULT nextval('public.gallery_table_gallery_id_seq'::regclass);
 G   ALTER TABLE public.gallery_table ALTER COLUMN gallery_id DROP DEFAULT;
       public          postgres    false    223    224    224            H           2604    16521    messages_review_table review_id    DEFAULT     �   ALTER TABLE ONLY public.messages_review_table ALTER COLUMN review_id SET DEFAULT nextval('public.messages_review_table_review_id_seq'::regclass);
 N   ALTER TABLE public.messages_review_table ALTER COLUMN review_id DROP DEFAULT;
       public          postgres    false    226    225    226            J           2604    16543    orders_table order_id    DEFAULT     ~   ALTER TABLE ONLY public.orders_table ALTER COLUMN order_id SET DEFAULT nextval('public.orders_table_order_id_seq'::regclass);
 D   ALTER TABLE public.orders_table ALTER COLUMN order_id DROP DEFAULT;
       public          postgres    false    228    227    228            N           2604    16575 (   paymenttransactions_table transaction_id    DEFAULT     �   ALTER TABLE ONLY public.paymenttransactions_table ALTER COLUMN transaction_id SET DEFAULT nextval('public.paymenttransactions_table_transaction_id_seq'::regclass);
 W   ALTER TABLE public.paymenttransactions_table ALTER COLUMN transaction_id DROP DEFAULT;
       public          postgres    false    230    229    230            =           2604    16433    users_table user_id    DEFAULT     z   ALTER TABLE ONLY public.users_table ALTER COLUMN user_id SET DEFAULT nextval('public.users_table_user_id_seq'::regclass);
 B   ALTER TABLE public.users_table ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    216    215    216                       0    16452    artworks_table 
   TABLE DATA           �   COPY public.artworks_table (artwork_id, title, description, user_id, category, style, creation_date, price, dimensions, medium, image_url, created_at) FROM stdin;
    public          postgres    false    218   �a                 0    16470    bidding_table 
   TABLE DATA           Z   COPY public.bidding_table (bid_id, artwork_id, user_id, bid_amount, bid_date) FROM stdin;
    public          postgres    false    220   ~f                 0    16488    events_table 
   TABLE DATA           �   COPY public.events_table (event_id, event_name, description, user_id, event_start_date, event_end_date, location, registration_form_link, link_end_date, created_at) FROM stdin;
    public          postgres    false    222   h                 0    16503    gallery_table 
   TABLE DATA           e   COPY public.gallery_table (gallery_id, name, location, description, user_id, created_at) FROM stdin;
    public          postgres    false    224   >m                 0    16518    messages_review_table 
   TABLE DATA           p   COPY public.messages_review_table (review_id, user_id, artwork_id, rating, review_text, created_at) FROM stdin;
    public          postgres    false    226   q       
          0    16540    orders_table 
   TABLE DATA           �   COPY public.orders_table (order_id, user_id, artwork_id, order_date, total_price, status, shipping_address, created_at) FROM stdin;
    public          postgres    false    228   	t                 0    16572    paymenttransactions_table 
   TABLE DATA           �   COPY public.paymenttransactions_table (transaction_id, order_id, user_id, payment_method, transaction_date, transaction_time, amount, status, created_at) FROM stdin;
    public          postgres    false    230   �v       �          0    16430    users_table 
   TABLE DATA           �   COPY public.users_table (user_id, username, email, password, first_name, last_name, profile_picture, bio, category, phone_number, address, gender, created_at) FROM stdin;
    public          postgres    false    216   �x                  0    0    artworks_table_artwork_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.artworks_table_artwork_id_seq', 25, true);
          public          postgres    false    217                       0    0    bidding_table_bid_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.bidding_table_bid_id_seq', 50, true);
          public          postgres    false    219                       0    0    events_table_event_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.events_table_event_id_seq', 25, true);
          public          postgres    false    221                       0    0    gallery_table_gallery_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.gallery_table_gallery_id_seq', 30, true);
          public          postgres    false    223                       0    0 #   messages_review_table_review_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.messages_review_table_review_id_seq', 30, true);
          public          postgres    false    225                        0    0    orders_table_order_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.orders_table_order_id_seq', 40, true);
          public          postgres    false    227            !           0    0 ,   paymenttransactions_table_transaction_id_seq    SEQUENCE SET     [   SELECT pg_catalog.setval('public.paymenttransactions_table_transaction_id_seq', 30, true);
          public          postgres    false    229            "           0    0    users_table_user_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.users_table_user_id_seq', 60, true);
          public          postgres    false    215            V           2606    16461 "   artworks_table artworks_table_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.artworks_table
    ADD CONSTRAINT artworks_table_pkey PRIMARY KEY (artwork_id);
 L   ALTER TABLE ONLY public.artworks_table DROP CONSTRAINT artworks_table_pkey;
       public            postgres    false    218            X           2606    16476     bidding_table bidding_table_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.bidding_table
    ADD CONSTRAINT bidding_table_pkey PRIMARY KEY (bid_id);
 J   ALTER TABLE ONLY public.bidding_table DROP CONSTRAINT bidding_table_pkey;
       public            postgres    false    220            Z           2606    16496    events_table events_table_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.events_table
    ADD CONSTRAINT events_table_pkey PRIMARY KEY (event_id);
 H   ALTER TABLE ONLY public.events_table DROP CONSTRAINT events_table_pkey;
       public            postgres    false    222            \           2606    16511     gallery_table gallery_table_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.gallery_table
    ADD CONSTRAINT gallery_table_pkey PRIMARY KEY (gallery_id);
 J   ALTER TABLE ONLY public.gallery_table DROP CONSTRAINT gallery_table_pkey;
       public            postgres    false    224            ^           2606    16527 0   messages_review_table messages_review_table_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.messages_review_table
    ADD CONSTRAINT messages_review_table_pkey PRIMARY KEY (review_id);
 Z   ALTER TABLE ONLY public.messages_review_table DROP CONSTRAINT messages_review_table_pkey;
       public            postgres    false    226            `           2606    16550    orders_table orders_table_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.orders_table
    ADD CONSTRAINT orders_table_pkey PRIMARY KEY (order_id);
 H   ALTER TABLE ONLY public.orders_table DROP CONSTRAINT orders_table_pkey;
       public            postgres    false    228            b           2606    16579 8   paymenttransactions_table paymenttransactions_table_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.paymenttransactions_table
    ADD CONSTRAINT paymenttransactions_table_pkey PRIMARY KEY (transaction_id);
 b   ALTER TABLE ONLY public.paymenttransactions_table DROP CONSTRAINT paymenttransactions_table_pkey;
       public            postgres    false    230            T           2606    16439    users_table users_table_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.users_table
    ADD CONSTRAINT users_table_pkey PRIMARY KEY (user_id);
 F   ALTER TABLE ONLY public.users_table DROP CONSTRAINT users_table_pkey;
       public            postgres    false    216            d           2606    16477    bidding_table fk_artwork    FK CONSTRAINT     �   ALTER TABLE ONLY public.bidding_table
    ADD CONSTRAINT fk_artwork FOREIGN KEY (artwork_id) REFERENCES public.artworks_table(artwork_id);
 B   ALTER TABLE ONLY public.bidding_table DROP CONSTRAINT fk_artwork;
       public          postgres    false    218    4694    220            j           2606    16556    orders_table fk_artwork_order    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders_table
    ADD CONSTRAINT fk_artwork_order FOREIGN KEY (artwork_id) REFERENCES public.artworks_table(artwork_id);
 G   ALTER TABLE ONLY public.orders_table DROP CONSTRAINT fk_artwork_order;
       public          postgres    false    4694    228    218            h           2606    16533 '   messages_review_table fk_artwork_review    FK CONSTRAINT     �   ALTER TABLE ONLY public.messages_review_table
    ADD CONSTRAINT fk_artwork_review FOREIGN KEY (artwork_id) REFERENCES public.artworks_table(artwork_id);
 Q   ALTER TABLE ONLY public.messages_review_table DROP CONSTRAINT fk_artwork_review;
       public          postgres    false    226    218    4694            l           2606    16585 *   paymenttransactions_table fk_order_payment    FK CONSTRAINT     �   ALTER TABLE ONLY public.paymenttransactions_table
    ADD CONSTRAINT fk_order_payment FOREIGN KEY (order_id) REFERENCES public.orders_table(order_id);
 T   ALTER TABLE ONLY public.paymenttransactions_table DROP CONSTRAINT fk_order_payment;
       public          postgres    false    230    4704    228            c           2606    16462    artworks_table fk_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.artworks_table
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 @   ALTER TABLE ONLY public.artworks_table DROP CONSTRAINT fk_user;
       public          postgres    false    216    218    4692            e           2606    16482    bidding_table fk_user_bid    FK CONSTRAINT     �   ALTER TABLE ONLY public.bidding_table
    ADD CONSTRAINT fk_user_bid FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 C   ALTER TABLE ONLY public.bidding_table DROP CONSTRAINT fk_user_bid;
       public          postgres    false    220    216    4692            f           2606    16497    events_table fk_user_event    FK CONSTRAINT     �   ALTER TABLE ONLY public.events_table
    ADD CONSTRAINT fk_user_event FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 D   ALTER TABLE ONLY public.events_table DROP CONSTRAINT fk_user_event;
       public          postgres    false    216    4692    222            g           2606    16512    gallery_table fk_user_gallery    FK CONSTRAINT     �   ALTER TABLE ONLY public.gallery_table
    ADD CONSTRAINT fk_user_gallery FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 G   ALTER TABLE ONLY public.gallery_table DROP CONSTRAINT fk_user_gallery;
       public          postgres    false    224    216    4692            k           2606    16551    orders_table fk_user_order    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders_table
    ADD CONSTRAINT fk_user_order FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 D   ALTER TABLE ONLY public.orders_table DROP CONSTRAINT fk_user_order;
       public          postgres    false    228    4692    216            m           2606    16580 )   paymenttransactions_table fk_user_payment    FK CONSTRAINT     �   ALTER TABLE ONLY public.paymenttransactions_table
    ADD CONSTRAINT fk_user_payment FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 S   ALTER TABLE ONLY public.paymenttransactions_table DROP CONSTRAINT fk_user_payment;
       public          postgres    false    216    4692    230            i           2606    16528 $   messages_review_table fk_user_review    FK CONSTRAINT     �   ALTER TABLE ONLY public.messages_review_table
    ADD CONSTRAINT fk_user_review FOREIGN KEY (user_id) REFERENCES public.users_table(user_id);
 N   ALTER TABLE ONLY public.messages_review_table DROP CONSTRAINT fk_user_review;
       public          postgres    false    226    216    4692                �  x����n�8��٧���|����a��E;S4����(�k�XIn�>�P�c;=��"�#ƤȟY+c5/,�Ж��Q�_�0F�FK^�l�l6����b�eˀŔ�S
)�g~�Z]���_6�*��"�)a�7���y�,�9;��;��di�� ��rY���ga���5�Zyo����l{�Y�($���S
�):�q�wW�ȝ\�G�xC
|6d'mE^�J�ƒB�JH��?�{U
ݸ�'�#6�EŌ�s
�>Բpa$�0R|Y���ț����1m���7��M����v,�O
�"���.���g�����E��"��G!0O�S?���Ynџ�M%�r��r��n��4ׇ>A9V
�Y��l�ep/�X�(%w!e��f�l#,�ւo\
�Z�nk���z��Sɺ60���Qm����3�x�2L�G��Bq��4�S�^����['IK�����b����y��z"ܫ�c��#�1���{z�v긩�N�H��5�h��W�t�&?�K���V8'4�I��t��dƄ�C�,�ny�ZN�/�q�X�#���1���"̧rAY�)��/�g,�iv�O�PD��\��!�V�>v��%b��g=M>�O�K�b�u|�F�!0x��=�k~��Bp
EE4'0�0���F`=Բl?��q���j+���Qz;i��p`*�jNz�]�Pͣxyv�?j�]�� ZYO�.{����n�e�eP ���X��?�}�M%��Le����M��Me��T9t���g+�5~��a�R�	��`1�kmA��P�F�����#�CRNJo�t�ʲ��D�T`���)�f#���;��䇀���7O0v*���Q'Î�	b���[���H}������زK�?�9sk E�g���� Pq�w#��L�^�	���5��>�/�0���	�V'�R�Wn�냑%"U���/>�ª���V�E���wR�� T�d�+�'��o��ַ�}kd�k�(Nv#�l���?�]r@(�Ʀ��B� Cc�M��Ĭ_at7O�&^;���>�ףI>�y��8���p�=:�TZ����r{G�}�\���sPwC%�.em�A�����I5��}��Q��p���փw��o�"J�8aN������FM�l��۪�GG����}��'�o1��L�I	��V�n�_�15�5���y�7�MgR{A�?��=�?1�3��������/�`�{         ~  x����m�0C��]��$�qf��sT?vO� �f��->� �A��n�/�/�/��n�L����pp�M	^�P�D�.Z#�cG�!ܑ��B�$��q�n�hґV�]�F����^�Ү����@׮���_ڵ����][E�V�K�v�������]/���ub��ؿO�C���5�N�5�DU �PCU\C�U�p5Z��U�J�
�W��)j�*�O]P#V)|
���j��WiP#�j���UԈE��A�X�]Ԑ���AMY\�<�1����5fi�>\c������] �1�����w�טe����ς�ߘ��n��#��y��mvG�#�ׯ���#�q��G�M�G�6?}��l�>8��Θ��>���9E|#         "  x��WAr�8<ï�d��HI���$Ζ�q���e/	��I����?�w��v � l�T��)ؘ��c�
z-ٞ)��C,K~̉d���x'1��ų�D�%Q��E�,�]G��**N�[CQ�T+����+�ۊ^漾�0��g�׳$���z����.�Y�.����jU'(��_[�ݒ��3�w��'.�X�P��-�=�(���TW0���oi�����x
�=�(]�{"aü"R�M�B���~U4/�wG��@t]7&��MN
Z����zw�_"\�v`�T��xGk����1T��f�jp�>L�#�v�1T�8�D��o�*8�{�*/u�>� %����;k�*)TR<�f�fh��	?��1d��ɖ�l�܈a[B�����m:��-�J$.}���@�1�A��d5ii A���N��R�R�.�	�'Ý��b/�fQK��u�����!��?6
�ᇊ�CƐ.]�t���J��� G͢��%�R����K��Vvu@�:|UdY������U�V�:+�S�rɺ�ƅ��hNT����GZ�.��{�:�g���K�&�6{	�ɕ��7O��SP��;ifr�
%%����c�^BG�mΌ�اM�:��c�W�7�f
~m��E���ѯ���S{#�a����y������r��v�nA���0��Z��i��x'y'�T{��p�;ۜ��39��I-�M��������T��]8�S��+B|{����;$�0�޶��9���w}�X֧ ���Q{�p���`�4a�Ѯ�y~�Q��&�5Mі
R����̇��m����N{~�+�q�ӧ�&��W�
�Xp]�τ�7&ۊ�$ޟ>8�@Zڿǆ\�Z~���'L��x�:�Ov(�@/�ck�T��7ə/�	�����x�R�T\��i˓Aa*�I{�ma��+XO��hY�Su�����\�����Yfo�t���ϛ�ε�J@%���W�sAD{#
�A�������V�l���琮]�����ue� e7�qw�	����O�:舵�T��[��߿���/��Scs�bKʵD���ƉT���ݻ�]��k?���7��I���H	{(��
��?Q}	ֈ���-�	ˋb�o69#�$q��m3�k�����ޑ�V_���~�G{O���pn�zGF?%�3�h�UP&x�-`P�`g��qh�a�T�R��	Jχ����;����OƅK:��|���n+pZ�}/ys)n�8�Ĭn��3�ͩ3��9���Ɂ�������מ�         �  x��V�r�8>3O�H�Rl'�͵�mw�nf����^h�0�HI�񭯱��O� )�Nڱ��D� ���fb���������#|�߬{ckT�u�m�"�u��ٵ�{y��ww��d6x��\_e���&���_n��d��Z #���Sf)}p ���1��bf������v���=.�Pk+���NVɚn σc������ ���)S�/���
]&����t��(�9ZP�� $B�D+f�*��W$?�FS(t�{
$�5����5�SK�H�	�ǟ��F�ɾ�l��u��S�A��֙,�\#c5aиV^��1̩-/�x��$�y4�;1vn@��,�.���F�K��P�
Utv��Z-��������H5�_��-��Px��3R� �Ĵ�$eru�N�l�������n�"��hlv;�$��|�C�Z-A�%����b�l%�-��O3���Y�ߏ�|PBH}1A�K��h|���8�����S����<BEyѭ��\�Y���8�1VfCnJ���lI)[�m��F(�4C1��lm51t/3���ϰ��Z)�j���+xq#>c7��Qx����1��9����g��`a�'�1��z�K��}썘�2�t�^�=q��� �k諤@/�����c%��a!�����ty����'N'Ϣ��с]EIM(�sWSލ���)d�\$����
����T+4L���P����q�fr�v�.��4��+yo􇛗+f�噃%�b�ΩՊ�p�[�V�A'8�?���<�� �դ�4��Ӗ���E���S����6�a�πd+Jϗ��$��)by�A�1l���&��H�=Y8�DEB�!�6-KvO�HH֬W�k~+�Ԇ�c3x�ф��K	������]���u���n�EC!k��ś�䃫������*6�����ګߙ�������Y��         �  x���Ko�0����`�N R���h(�K�^z�%�bC�I9v}g%���cp����H0Q2�*vש�m���Zs��*�)��p�N�X�\1Y��u���խ�UyS��jQN$3&ٌ}�{���j^{�C�}����'I�هǛ��X��\tc�Vsz4劧�kީ�t&�
͘�c���{�L��O����ģ�47�.`�N��RL4cx�c4{�UJxg<V�#e5�L,�G���<����X��Z�x��g�Ċ�w��m��%��9���Y�l��OU%Z����;`~����G┲��l��~7p�	�4;]'�t>��0LA���r	@M}��>B0	�ltO�@�.�Cꁇ+׌�ˏ!��G$���Μ��N���1���:%�it;�U5��+ ;sJЙ�N[S
�P^�brA���ԛ�Դ��<�x���U`�%��b���ր���9`ٍ�� �|X���̀N5�ڋ�������9��5�t��}��6y��Ppd�;��ھT�Ñ�*��!0ٌ�&]��<��X}�5RxADT�u�Zw&\BBA�S\J�7t�<vc��z,/TY�[k�'������_�?�1#,�|��.�Z�o�t�1		5:���t�������v^�s�e������Sn�4�a�� �E���1�~92�ؗ�(>ʾ���o�G��
���Ȟ(��|h�S��bĤz�B�X��������L&����      
   �  x����j�@���O������n���B���zcb��ʶ�MK߾�+*���`���=g (�̕WJ
���^�\Y��[@+�JJ8�TMSn �w�.��i)n�ӟ_U]���;�c
� �	6�4�nS��X'��?��������<~�d4���(����R'��A|�vmCw��o�uu\�/�9)�pR��'��x_o���v]�'jk)>|�T�˩计��)��m�Y��}�ie>�2�c9Pv07킸�O/I�zN4��GN�(PPpJC�L������S�gh�8�0..8��!�ez�>�әC2r�L�Wr�L��
@�Н�OawH��Yo@ݟ^t���\! ���ސ�v_?94�wj8���9�9h�}R�F*��W@[���;���t�<�Ŧ����ʠ/@[�V�g	���� �z{|؟_}:~]�&;}]q�d/��R�+֓.��R�+�g�÷�G�FWok�>|��K���J�g//v)7��B���6��|����NG/����(f�]�=�T�yBWc62Β�:lfW��#�lh(3S��tc�Q��y:]#������Nw�Y��y:�n��,��ӭ1�Z��<�����7K<�y�g�{���׫�"���Z,���s           x��V�n�0<���?��|�����c/j�A7ps��w�h�T�0��Ý��
x�.�����|=����t\���ycN��������o�9��.d6'�Ȓ?04�i��4��p���n���,,(�J�2UH6���r9?_�����>._� �!o�#;G/�1G/��d
�5�)0��|�q�t�/��-�5��e�ڰ��	�c�S��T��#"���ei��h��ޡMB��6	2Ŷ?IA���e=��̥i�o,I�*� p�Ч���d���L�{�1W.�P�c�p�Xp��H�#�DV(6q�4���]'�f�ŋEFڗ��܌���6d
��lK����j8��ƒ鱴4�խN�����5#Mh5i*#m2��O\��v\V���i��Kε�$���%��2Z��zy�&�%�Z��$Od�=K��;�h$OŠ-EXcPI�VÃ�zwTԨ%�6���K܎��2���M'qu���F�X���J\��5��T�nl%N��ɚ��`�J����F�ϧ�����-u      �   �  x��X�Z�6�O�(|+v�\�C����Z�~��v�`[[�l��#Y2��
�W�7�k����IC�J^���h�*�A*J��u}/dF�<e�H	уo�%���+�~��F�FH|ϛ�xè��X`��b��*e�^��x�?�'�k������fźj��e%-
&A�?I��	&��dvH&�$	�x/hU��K�X�l�4�sZ�%���ny�,]K �i�a^-$N�Y�>�����%s��?<l���$���;�5��f����5c�QFzCk�Kő��jz(�
��݋ID���=����)�����j��Қǉ�W�JH*7x�
��H׵�!*Lo������l�&"���[��z)��(��e�探�t]���V���V��T.�&��WuC��6\Tu���������q05jC�zy����EgE�6ncwh2o%c�X��Q��[u�&i΋L���7B��҉Q������j�+�y����4�!��s�6�7R�̫X�k
��$�kߙLQ�;���'27J���^�Ѫ�9��E#����I�2����K9-�ws�N�2�=�L�����X��Gw��d�Һ��K�V�PV9O�)�����L5�13wb=�K��K�q��c��FmO�xέ��h��5��xO�[tQ�wOd�9�Q%�Q��ȸ
l �Π�%��M����̀!6�Z7�{��N%E'L�R�0�m��/�.B$��XW��V��ͱ��4�>�S��\�\���&�O�&�!�YW8t�A[�R�
^�}�	J��"!��/�d����,�>Y���O�A���K]G 4䩜�pS;���DD&��>��G��֣��G<N��e�
����1N?�-��%�<8f
���s���!-!�o��"~*84Nm7�}.�ֹ�m�N����'��M'6��"St��(?k/��b䲄00�ݑ �-��:S�L�����ېcDB|����Y�00���5�*��FTc������� ����,�y�54����@��;#�a�y�(�*T� �:c��ش���3Dbc�A���*#�x1_6b� ��j�g*G2��덭U��~u��T�� ���b�xa^�Dqtk$ê�S7%��!�K�
��	"3h�Do��WI\&��-�%E�E^uƝv~�U�3� ]dO�BB�dA�@7Ld�8�71rh��u�fD{��^����~!R���JY�@'�$���g��.0�f��ߴ\�*۠+�)����]"+T~R�w:�>��~]m�2�	>����/H���(۲�F�\ym���l���;D�wR/o�dbW/ꯪY<R�;�=&,m��g�K����-�>+7h�c��|����`�
2�������V%\�TO�'�6�Q��Ġ�b"�v����=�EPJ[I`oz���J�	��M��L>EA��]���Y_1�IB��gj�((���-�V����޳�.>CA��v������	K��?XU7`򢰢N��;i��L�	�Q �R#2 /�62m����)�V}�K+�o]|x���\�� OP0��J�\I�ѐ�n�F�!x�<�΃`/��E>�9��b��d��h'�.����]:��%�$�=Lvٌt��ЈF<Mv��p��R�4��?�i��c��d���a��rz��d��&�(�0Mv1��i�3�4م�j��.�M�]��&��0Mv1�h��B�4�?�i��y\�d�X���騦��������#     