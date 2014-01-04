	
	<div id="div-html-editor" title="HTML Editor">
            <textarea id="editor1" name="editor1" rows="10" cols="80">
                Paste text to edit.
            </textarea>	
            
            <p class="editor-buttons">
            	<input type="button" value="Cancel" onclick="closeEditor()"/>
            	&nbsp;&nbsp;
            	<input type="button" value="Save" onclick="saveEditor()" />
            	&nbsp;&nbsp;
            	<input type="button" value="Save as Paragraph(s)" onclick="saveEditorP()" />
            
            </p>
            
            <p class="help-text">
            	<strong>Important!</strong>  This HTML editor automatically puts paragraph tags around your
            	data.  All paragraph tags will be REMOVED unless you specifically choose to save them
            	by clicking on the "Save as Paragraph(s)" button.
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