<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<div class="row">


	<hr>
	<div class="col-md-10 col-xs-10">
		

		
			<h2><spring:message code="a.it_ticket.faq" /></h2>
			
			<div class="container">
    <br />
    <br />
    <br />

    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <spring:message code="a.it_ticket.faq.note" />
    </div>

    <br />

    <div class="panel-group" id="accordion">
    <div class="faqHeader">الأسئلة الشائعة </div>
       
       
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#a1">أرشفة العناصر القديمة يدوياً في Outlook for Windows</a>
                </h4>
            </div>
            <div id="a1" class="panel-collapse collapse">
                <div class="panel-body">
<article id="ocpArticleContent" class="ocpArticleContent"><a name="__top" ms.cmpgrp="content" ms.pgarea="Body">	</a><section class="ocpIntroduction"><p class="ocpAlertSection"><b class="ocpNote">هام:</b>&nbsp;تمت ترجمة هذه المقالة ترجمة آلية، راجع <a href="#mt_footer" class="ocpInlineLink" ms.cmpgrp="content" ms.pgarea="Body" ms.interactiontype="11">إقرار إخلاء المسؤولية</a>. يرجى الاطلاع على النسخة الإنجليزية من هذه المقالة. <a href="https://support.office.com/en-us/article/fa03020e-55af-4eeb-94fb-925f640d942d" class="ocpExternalLink" target="_blank" ms.cmpgrp="content" ms.pgarea="Body">هنا</a> للرجوع إليها.</p><a name="bmbacktotop" ms.cmpgrp="content" ms.pgarea="Body">	</a><p>لقد ازداد حجم علبة بريدك في Outlook، ولا تريد على الأرجح أن تتوقف عن تلقي أي بريد إلكتروني في وقت قريب. لمنع امتلاء علبة البريد، يمكنك نقل العناصر القديمة التي تريد الاحتفاظ بها إلى ملف <i class="ocpItalic">أرشيف</i>، ملف Outlook Data File (.pst)‎ منفصل يمكنك فتحه من Outllok في أي وقت تحتاج فيه إليه.</p><p>بشكل افتراضي، يستخدم Outlook الأرشفة التلقائية لأرشفة العناصر عند فاصل زمني منتظم. لمعرفة المزيد، راجع <a href="أرشفة-العناصر-القديمة-تلقائياً-25f44f07-9b80-4107-841c-41dc38296667" class="ocpArticleLink" ms.cmpgrp="content" ms.pgarea="Body">أرشفة العناصر القديمة تلقائياً</a>.</p><p>يمكنك أيضاً أرشفة العناصر القديمة يدوياً كلما أردت ذلك. باستخدام هذه الطريقة، ستتمكّن من التحكم في اختيار العناصر التي تريد أرشفتها، وموقع أرشفتها، والعمر الذي يجب أن تبلغه العناصر قبل أرشفتها.</p><ol type="1"><li><p>قم بواحد مما يلي:</p><ul><li><p>في <b class="ocpLegacyBold">Outlook 2013:</b> انقر فوق <b class="ocpUI">ملف</b> &gt; <b class="ocpUI">معلومات</b> &gt; <b class="ocpUI">ادوات التنظيف</b> &gt; <b class="ocpUI">ارشفه</b>.</p><p><br><img src="https://support.content.office.net/ar-sa/media/91679217-1546-4ffe-bb77-ede34ddae727.jpg" alt="أرشيف" title="أرشيف" ms.cmpgrp="content" ms.pgarea="Body" ms.interactiontype="500"></p></li><li><p>في <b class="ocpLegacyBold">Outlook 2016</b>: انقر فوق <b class="ocpUI">ملف</b> &gt; <b class="ocpUI">معلومات</b> &gt; <b class="ocpUI">ادوات</b> &gt; <b class="ocpUI">مسح العناصر القديمه</b></p><p><img src="https://support.content.office.net/ar-sa/media/9eb40f6f-1b21-4495-8840-527031317651.png" alt="مسح العناصر القديمة" title="مسح العناصر القديمة" ms.cmpgrp="content" ms.pgarea="Body" ms.interactiontype="500"></p></li></ul><p class="ocpAlertSection"><b class="ocpNote">تلميح:</b>&nbsp;قد لا تتوفر الأرشفة والأرشفة التلقائية إذا كان ملف تعريف بريدك يتصل بخادم Exchange Server. كما أنه من المحتمل أن تكون شركتك قد وضعت نهجاً لاستبقاء البريد يُبطل الأرشفة التلقائية. اتصل بمسؤول النظام للحصول على المزيد من المعلومات.</p></li><li><p>انقر فوق الخيار <b class="ocpUI">أرشفة هذا المجلد وكافة المجلدات الفرعية</b>، ثم اختر المجلد الذي تريد أرشفته.</p></li><li><p>ضمن <b class="ocpUI">أرشفة العناصر الأقدم من</b>، قم بإدخال تاريخ.</p><p><img src="https://support.content.office.net/ar-sa/media/3ee2600e-054f-43c6-bb3c-6ba65fb31511.jpg" alt="مربع الحوار &quot;أرشيف&quot;" title="مربع الحوار &quot;أرشيف&quot;" ms.cmpgrp="content" ms.pgarea="Body" ms.interactiontype="500"></p></li><li><p>يمكنك إنشاء ملفات pst. متعددة إذا كنت تريد أرشفة بعض المجلدات باستخدام إعدادات مختلفة. على سبيل المثال، قد تريد الاحتفاظ بالعناصر في مجلد "المرسلة" فترة أطول من فترة الاحتفاظ بها في مجلد "علبة الوارد".</p></li><li><p>حدد خانة الاختيار <b class="ocpUI">تضمين العناصر التي تم اختيار "عدم الأرشفة التلقائية" لها</b> لتضمين عناصر فردية مستبعدة من الأرشفة التلقائية. لا يؤدي هذا الخيار إلى إزالة ذلك الاستبعاد من تلك العناصر، بل يتجاهل بدلاً من ذلك الإعداد <b class="ocpUI">عدم الأرشفة تلقائياً</b> لهذه الأرشفة فقط.</p></li><li><p>انقر فوق <b class="ocpUI">موافق</b>.</p></li></ol></section><section class="ocpSection"><h2>إيقاف تشغيل الأرشفة التلقائية</h2><p>لأرشفة العناصر فقط عندما تريد ذلك، يجب إيقاف تشغيل الأرشفة التلقائية.</p><ol type="1"><li><p>انقر فوق <b class="ocpUI">ملف</b> &gt;‏ <b class="ocpUI">خيارات</b> ‏&gt; <b class="ocpUI">خيارات متقدمة</b>.</p></li><li><p>ضمن <b class="ocpUI">أرشفة تلقائية</b>، انقر فوق <b class="ocpUI">إعدادات الأرشفة التلقائية</b>.</p></li><li><p>قم بإلغاء تحديد خانة الاختيار <b class="ocpUI">تشغيل الأرشفة التلقائية كل n يوم/أيام</b>.</p></li></ol> <a href ="https://support.office.com/ar-sa/article/%D8%A3%D8%B1%D8%B4%D9%81%D8%A9-%D8%A7%D9%84%D8%B9%D9%86%D8%A7%D8%B5%D8%B1-%D8%A7%D9%84%D9%82%D8%AF%D9%8A%D9%85%D8%A9-%D9%8A%D8%AF%D9%88%D9%8A%D8%A7%D9%8B-%D9%81%D9%8A-Outlook-for-Windows-fa03020e-55af-4eeb-94fb-925f640d942d">المصدر : دعم مايركوسوفت</a></section></article>
                </div>
            </div>
        </div>
        
        
        
        
        
        <div class="faqHeader">Frequent questions</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#e1"> How to Archive email in Outlook 2010  </a>
                </h4>
            </div>
            <div id="e1" class="panel-collapse collapse in">
                <div class="panel-body">
                
                <div id="mt1" class="kb-resolution-section section ng-scope"><div class="section-header"><h5 class="section-title">Resolution</h5></div><h4 class="sbody-h4">What is an Archive and what does it do?</h4><br><br>In most cases Outlook keeps all your email in a file called the Outlook Data File (sometimes called the .pst file) locally on your PC. The Personal Folders and all the sub folders listed on the left side of the Outlook screen are a snapshot of what is in the Outlook Data File. So if you take into consideration all the pictures, documents, videos and music you might have in your email, the file can become quite large. <br><br>Outlook can only use the computer resources available to it. An Archive is a way to reduce the size of your Outlook Data File when the amount of email you keep starts to tax your computers resources, causing it to slow down. Unlike a traditional backup in which a copy is made, archived items are moved to a separate Outlook Data File and set aside to be accessed when needed. <br><br>To learn more about AutoArchive or Archiving in general, see <a id="kb-link-1" href="http://office.microsoft.com/en-us/outlook-help/redir/HA010354967.aspx?CTT=5&amp;origin=HA010355564" target="_self">Use AutoArchive to back up or delete items</a><a id="kb-link-2" href="http://office.microsoft.com/en-us/outlook-help/redir/HA010105706.aspx?CTT=5&amp;origin=HA010355564" target="_self"></a>.<br><br><h4 class="sbody-h4">Where is the Archive file located?</h4><br><br>The location of the archive Outlook Data File (.pst) varies depending on the version of Microsoft Windows you have&nbsp;on your computer when you create the archive. New archives created with Microsoft Outlook 2010 are saved in the following locations:<br><br><span class="text-base">Windows 7 and Windows Vista</span><br><br>drive:\Users\&lt;Your LogInName&gt;\Documents\Outlook Files\archive.pst<br><br><span class="text-base">Windows XP</span><br><br>drive:\Documents and Settings\&lt;Your LogInName&gt;\Local Settings\Application Data\Microsoft\Outlook\archive.pst<br><br>If your computer previously had an earlier version of Outlook installed, archive Outlook Data Files (.psts) created by the earlier versions of Outlook are saved in the following locations:<br><br><span class="text-base">Windows 7 and Windows Vista</span><br><br>drive:\Users\&lt;Your LogInName&gt;\AppData\Local\Microsoft\Outlook\archive.pst<br><br><span class="text-base">Windows XP</span><br><br>drive:\Documents and Settings\&lt;Your LogInName&gt;\Local Settings\Application Data\Microsoft\Outlook\archive.pst<br><br><h4 class="sbody-h4">How do I create an Archive file?<br></h4><br>By default Outlook 2010 does not have an Archive file, one has to be created manually. Once the file has been created, you'll need to check the AutoArchive settings to see if the default settings meet your needs.<br><br><ol class="sbody-num_list"><li>Open Outlook.&nbsp;</li><li>Select: <span class="text-base">File</span> &gt; <span class="text-base">Info</span> &gt; <span class="text-base">Cleanup Tools </span>(Mailbox Cleanup).</li><li>Click on <span class="text-base">Archive</span> in the dropdown box.</li><li>In the window that opens you can change the settings to Archive: <br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721866.png" alt="" title=""><ul class="sbody-free_list"><li>All your folders and subfolders.</li><li>A single folder and all its subfolders.</li><li>Set Outlook to Archive everything before a specified date.</li></ul></li><li>Click <span class="text-base">OK</span> and the Archive file will be created and attached to Outlook.</li><li>The Archive process will then run using the settings you previously entered. All email received before the date you selected will be moved to the Archive file. If the email being Archived is in a folder named John Doe, it will be stored in a folder named John Doe in the Archive file. If a folder does not have email old enough to be Archived, the folder&nbsp;will not be created in the Archive file until it does.&nbsp;<br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721873.png" alt="" title=""><br><br><span class="text-base">Note:</span>&nbsp;To see if the Archive process is running, look at the lower right-hand corner of the Outlook screen.<br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721901.png" alt="" title=""><br><br></li><li>When the Archive process has finished, right-click on the <span class="text-base">Archive</span> and select <span class="text-base">Close</span><span class="text-base">"archive".</span><br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721908.png" alt="" title=""><br><br><br></li></ol><h4 class="sbody-h4">How do I set Archiving to run automatically?</h4><br><br><br>Set what is Archived and when&nbsp;AutoArchive runs.<br><br><ol class="sbody-num_list"><li>Go to: <span class="text-base">File</span> &gt; <span class="text-base">Options</span> &gt; <span class="text-base">Advanced</span>.</li><li>Scroll down until you find <span class="text-base">AutoArchive</span> and click on <span class="text-base">AutoArchive Settings</span>.</li><li>In the window that opens you can set the following options. <br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721981.png" alt="" title=""><ul class="sbody-free_list"><li>Run AutoArchive every XX days.</li><li>Prompt before running AutoArchive.</li><li>Delete expired items (email folders only).</li><li>Archive or delete old items.</li><li>Show archive folder in folder list.</li><li>Set Archive to clean out email older than XX months.</li><li>Pick the Archive folder to send the old email to (Leave at default).</li></ul></li></ol><h4 class="sbody-h4">How do I open an Archive file?</h4><br><br><div id="bookmark-open"></div><br>In order to have the most computer resources available, it's best to leave you Archive file closed and only open it when needed.<br><ol class="sbody-num_list"><li>Go to: <span class="text-base">File</span> &gt; <span class="text-base">Open</span> &gt; <span class="text-base">Open Outlook Data File</span>.<br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721987.png" alt="" title=""></li><li>Select the Archive file you want to open and click <span class="text-base">OK</span>. The Archive file will appear underneath your regular email file. <br><img class="graphic" src="https://support.microsoft.com/Library/Images/2721998.png" alt="" title=""></li></ol><br><h4 class="sbody-h4">How do I restore mail back to my main folders?</h4><br><br>Open your Archive&nbsp;using the steps outlined in: <span class="text-base">How do I open an Archive file</span>? With both your normal email file and the Archive file open you can drag and drop email between the two as you see fit.<br><br><span class="text-base">  </div>
                    <hr> ref : <a href="https://support.microsoft.com/en-us/kb/2720581">Microsoft Support</a>
                </div>
            </div>
        </div>
        

        
    </div>
</div>


	</div>

</div>



<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>