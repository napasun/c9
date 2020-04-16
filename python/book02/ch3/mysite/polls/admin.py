from django.contrib import admin
from polls.models import Question, Choice

# Register your models here.

class ChoiceInline(admin.TabularInline):  #admin.StackedInline
    model = Choice
    extra = 2

class QuestionAdmin(admin.ModelAdmin):
    fieldsets = [
        (None, {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date'], 'classes': ['collapse']}),
    ]
    inlines = [ChoiceInline] # Choice 모델 클래스 같이 보기
    list_display = ('question_text', 'pub_date')    #리스트 컬럼 항목
    list_filter = ['pub_date']  #필터
    search_fields = ['question_text']
    #fields = ['pub_date', 'question_text'] #필드 순서 변경

admin.site.register(Question, QuestionAdmin)
admin.site.register(Choice)
