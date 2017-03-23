package com.lamp.ledis.entity;
import org.junit.Test;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TestCreate extends ClassLoader implements Opcodes {
	
	
	@Test
	public void test(){
		byte[ ] code;
		try {
			code = dump( );
			Class< ? > exampleClass = this.defineClass( "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" , code , 0 , code.length ) ;
		} catch ( Exception e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static byte[ ] dump( ) throws Exception {

		ClassWriter cw = new ClassWriter( 0 );
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit( 52 , ACC_PUBLIC + ACC_SUPER , "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" ,
				"Lcom/lamp/ledis/create/AbstractKeyCreate<Lcom/lamp/ledis/entity/TestEntity;>;" ,
				"com/lamp/ledis/create/AbstractKeyCreate" , null );

		cw.visitSource( "TestEntityKeyCreates.java" , null );

		{
			mv = cw.visitMethod( ACC_PUBLIC , "<init>" , "(Ljava/lang/String;)V" , null , null );
			mv.visitCode( );
			Label l0 = new Label( );
			mv.visitLabel( l0 );
			mv.visitLineNumber( 10 , l0 );
			mv.visitVarInsn( ALOAD , 0 );
			mv.visitVarInsn( ALOAD , 1 );
			mv.visitMethodInsn( INVOKESPECIAL , "com/lamp/ledis/create/AbstractKeyCreate" , "<init>" ,
					"(Ljava/lang/String;)V" , false );
			Label l1 = new Label( );
			mv.visitLabel( l1 );
			mv.visitLineNumber( 11 , l1 );
			mv.visitInsn( RETURN );
			Label l2 = new Label( );
			mv.visitLabel( l2 );
			mv.visitLocalVariable( "this" , "Lname_5_com_lamp_ledis_entity_TestEntity_KeyCreate;" , null , l0 , l2 , 0 );
			mv.visitLocalVariable( "key" , "Ljava/lang/String;" , null , l0 , l2 , 1 );
			mv.visitMaxs( 2 , 2 );
			mv.visitEnd( );
		}
		{
			mv = cw.visitMethod( ACC_PUBLIC , "getKeySuffix" ,
					"(Lcom/lamp/ledis/entity/TestEntity;)Ljava/lang/String;" , null , null );
			mv.visitCode( );
			Label l0 = new Label( );
			mv.visitLabel( l0 );
			mv.visitLineNumber( 15 , l0 );
			mv.visitVarInsn( ALOAD , 0 );
			mv.visitVarInsn( ALOAD , 1 );
			mv.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/entity/TestEntity" , "getId" , "()I" , false );
			mv.visitMethodInsn( INVOKEVIRTUAL , "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" , "getKey" ,"(I)Ljava/lang/String;" , false );
			mv.visitInsn( ARETURN );
			Label l1 = new Label( );
			mv.visitLabel( l1 );
			mv.visitLocalVariable( "this" , "Lname_5_com_lamp_ledis_entity_TestEntity_KeyCreate;" , null , l0 , l1 , 0 );
			mv.visitLocalVariable( "t" , "Lcom/lamp/ledis/entity/TestEntity;" , null , l0 , l1 , 1 );
			mv.visitMaxs( 2 , 2 );
			mv.visitEnd( );
		}
		{
			mv = cw.visitMethod( ACC_PUBLIC , "getKeySuffixBuffer" ,
					"(Lcom/lamp/ledis/entity/TestEntity;Ljava/nio/ByteBuffer;)V" , null , null );
			mv.visitCode( );
			Label l0 = new Label( );
			mv.visitLabel( l0 );
			mv.visitLineNumber( 21 , l0 );
			mv.visitVarInsn( ALOAD , 0 );
			mv.visitVarInsn( ALOAD , 1 );
			mv.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/entity/TestEntity" , "getName" ,
					"()Ljava/lang/String;" , false );
			mv.visitVarInsn( ALOAD , 2 );
			mv.visitMethodInsn( INVOKEVIRTUAL , "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" , "getKey" ,
					"(Ljava/lang/String;Ljava/nio/ByteBuffer;)V" , false );
			Label l1 = new Label( );
			mv.visitLabel( l1 );
			mv.visitLineNumber( 22 , l1 );
			mv.visitInsn( RETURN );
			Label l2 = new Label( );
			mv.visitLabel( l2 );
			mv.visitLocalVariable( "this" , "Lname_5_com_lamp_ledis_entity_TestEntity_KeyCreate;" , null , l0 , l2 , 0 );
			mv.visitLocalVariable( "t" , "Lcom/lamp/ledis/entity/TestEntity;" , null , l0 , l2 , 1 );
			mv.visitLocalVariable( "byteBuffer" , "Ljava/nio/ByteBuffer;" , null , l0 , l2 , 2 );
			mv.visitMaxs( 3 , 3 );
			mv.visitEnd( );
		}
		{
			mv = cw.visitMethod( ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC , "getKeySuffix" ,
					"(Ljava/lang/Object;)Ljava/lang/String;" , null , null );
			mv.visitCode( );
			Label l0 = new Label( );
			mv.visitLabel( l0 );
			mv.visitLineNumber( 1 , l0 );
			mv.visitVarInsn( ALOAD , 0 );
			mv.visitVarInsn( ALOAD , 1 );
			mv.visitTypeInsn( CHECKCAST , "com/lamp/ledis/entity/TestEntity" );
			mv.visitMethodInsn( INVOKEVIRTUAL , "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" , "getKeySuffix" ,
					"(Lcom/lamp/ledis/entity/TestEntity;)Ljava/lang/String;" , false );
			mv.visitInsn( ARETURN );
			mv.visitMaxs( 2 , 2 );
			mv.visitEnd( );
		}
		{
			mv = cw.visitMethod( ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC , "getKeySuffixBuffer" ,
					"(Ljava/lang/Object;Ljava/nio/ByteBuffer;)V" , null , null );
			mv.visitCode( );
			Label l0 = new Label( );
			mv.visitLabel( l0 );
			mv.visitLineNumber( 1 , l0 );
			mv.visitVarInsn( ALOAD , 0 );
			mv.visitVarInsn( ALOAD , 1 );
			mv.visitTypeInsn( CHECKCAST , "com/lamp/ledis/entity/TestEntity" );
			mv.visitVarInsn( ALOAD , 2 );
			mv.visitMethodInsn( INVOKEVIRTUAL , "name_5_com_lamp_ledis_entity_TestEntity_KeyCreate" , "getKeySuffixBuffer" ,
					"(Lcom/lamp/ledis/entity/TestEntity;Ljava/nio/ByteBuffer;)V" , false );
			mv.visitInsn( RETURN );
			mv.visitMaxs( 3 , 3 );
			mv.visitEnd( );
		}
		cw.visitEnd( );

		return cw.toByteArray( );
	}
}
