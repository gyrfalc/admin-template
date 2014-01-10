<%@ include file="/common/taglibs.jsp"%>
	
	<div id="div-html-editor" title="HTML Editor">
            <textarea id="editor1" name="editor1" rows="10" cols="80">
                Paste text to edit.
            </textarea>	
            
            <p class="editor-buttons">
            	<button onclick="closeEditor()"><s:text name="html.editor.cancel"/></button>
            	&nbsp;&nbsp;
            	<button onclick="saveEditor()"><s:text name="html.editor.save"/></button>
            	&nbsp;&nbsp;
            	<button onclick="saveEditorP()"><s:text name="html.editor.save.paragraph"/></button>
            
            </p>
            
            <p class="help-text">
            	<s:text name="html.editor.warn"/>
            </p>
	</div>
     <script>
         // Replace the <textarea id="editor1"> with a CKEditor
         // instance, using default configuration.
         CKEDITOR.replace( 'editor1' );
         
         var htmlSrcFldId;
         
         function showEditor(txtFldId) {
        	//alert("show editor: " + txtFldId);
        	htmlSrcFldId = txtFldId;
        	CKEDITOR.instances.editor1.setData( $(txtFldId).val() );
         	$("#div-form-editor").hide();
         	$("#div-action-menu").hide();
         	$("#div-html-editor").show();
         }
         
         function closeEditor() {
          	$("#div-html-editor").hide();
         	$("#div-form-editor").show();
         	$("#div-action-menu").show();
         }
         
         function saveEditor() {
        	var s = CKEDITOR.instances.editor1.getData();
        	s = s.replace(/<p>/gi, '');
        	s = s.replace(/<\/p>/gi, '');
        	$(htmlSrcFldId).val(s);
           	closeEditor();
          }
         
         function saveEditorP() {
         	$(htmlSrcFldId).val(CKEDITOR.instances.editor1.getData());
            	closeEditor();
         }
     </script>	